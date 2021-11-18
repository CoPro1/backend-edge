package cn.edu.sjtu.ist.ecssbackendedge.dao.impl;

import cn.edu.sjtu.ist.ecssbackendedge.component.QuartzScheduler;
import cn.edu.sjtu.ist.ecssbackendedge.dao.DeviceDataDao;
import cn.edu.sjtu.ist.ecssbackendedge.dao.SensorDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.po.sensor.SensorPO;
import cn.edu.sjtu.ist.ecssbackendedge.model.sensor.Sensor;
import cn.edu.sjtu.ist.ecssbackendedge.model.sensor.Status;
import cn.edu.sjtu.ist.ecssbackendedge.repository.SensorRepository;
import cn.edu.sjtu.ist.ecssbackendedge.utils.convert.CollectSchedulerUtil;
import cn.edu.sjtu.ist.ecssbackendedge.utils.convert.DataCollectorUtil;
import cn.edu.sjtu.ist.ecssbackendedge.utils.convert.SensorUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief SensorDaoImpl
 * @author rsp
 * @version 0.1
 * @date 2021-11-19
 */
@Slf4j
@Component
public class SensorDaoImpl implements SensorDao {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private DeviceDataDao deviceDataDao;

    @Autowired
    private SensorUtil sensorUtil;

    @Autowired
    private DataCollectorUtil dataCollectorUtil;

    @Autowired
    private CollectSchedulerUtil collectSchedulerUtil;

    @Override
    public void createSensor(Sensor sensor) {
        SensorPO sensorPO = sensorUtil.convertDomain2PO(sensor);
        sensorRepository.save(sensorPO);
    }

    @Override
    public void deleteSensorById(String id) {
        sensorRepository.deleteSensorPOById(id);
    }

    @Override
    public void deleteSensorByDeviceId(String deviceId) {
        sensorRepository.deleteSensorPOSByDeviceId(deviceId);
    }

    @Override
    public void updateSensor(Sensor sensor) {
        SensorPO res = sensorRepository.findSensorPOById(sensor.getId());
        res.setName(sensor.getName());
        res.setStatus(sensor.getStatus());
        res.setCollectorScheduler(collectSchedulerUtil.convertDomain2PO(sensor.getCollectorScheduler()));
        res.setDataCollector(dataCollectorUtil.convertDomain2PO(sensor.getDataCollector()));
        sensorRepository.save(res);
    }

    @Override
    public void updateSensorStatus(String id, Status status) {
        SensorPO res = sensorRepository.findSensorPOById(id);
        if (res == null) {
            log.warn("更新sensor状态，sensor在数据库中不存在");
        } else {
            res.setStatus(status);
            sensorRepository.save(res);
        }
    }

    @Override
    public Sensor findSensorById(String id) {
        SensorPO po = sensorRepository.findSensorPOById(id);
        if (po == null) {
            throw new RuntimeException("数据采集过程不存在");
        }

        Sensor sensor = sensorUtil.convertPO2Domain(po);
        sensor.setQuartzScheduler(quartzScheduler);
        sensor.setSensorDao(this);
        sensor.setDeviceDataDao(deviceDataDao);
        return sensor;
    }

    @Override
    public Sensor findSensorByDeviceIDAndName(String deviceId, String name) {
        SensorPO po = sensorRepository.findSensorPOByDeviceIdAndName(deviceId, name);
        if (po != null) {
            Sensor sensor = sensorUtil.convertPO2Domain(po);
            sensor.setQuartzScheduler(quartzScheduler);
            sensor.setSensorDao(this);
            sensor.setDeviceDataDao(deviceDataDao);
            return sensor;
        }
        return null;
    }

    @Override
    public List<Sensor> findSensorsByDeviceId(String id) {
        List<SensorPO> sensors = sensorRepository.findSensorPOSByDeviceId(id);
        List<Sensor> res = new ArrayList<>();
        for (SensorPO sensorPO : sensors) {
            Sensor sensor = sensorUtil.convertPO2Domain(sensorPO);
            sensor.setQuartzScheduler(quartzScheduler);
            sensor.setSensorDao(this);
            sensor.setDeviceDataDao(deviceDataDao);
            res.add(sensor);
        }
        return res;
    }
}
