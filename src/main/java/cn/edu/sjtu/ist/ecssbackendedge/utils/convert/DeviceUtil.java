package cn.edu.sjtu.ist.ecssbackendedge.utils.convert;

import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.device.DeviceDTO;
import cn.edu.sjtu.ist.ecssbackendedge.entity.po.device.DevicePO;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.device.Device;

import org.springframework.stereotype.Component;

/**
 * @author rsp
 * @version 0.1
 * @brief 设备对象转换工具类
 * @date 2021-11-20
 */
@Component
public class DeviceUtil {

    public Device convertDTO2Domain(DeviceDTO dto) {
        Device res = new Device();
        res.setId(dto.getId());
        res.setName(dto.getName());
        res.setModel(dto.getModel());
        res.setCredibility(dto.getCredibility());
        res.setCrafts(dto.getCrafts());
        res.setDescription(dto.getDescription());
        res.setValues(dto.getValues());
        res.setLongitude(dto.getLongitude());
        res.setLatitude(dto.getLatitude());
        res.setFailure_rate(dto.getFailure_rate());
        res.setRepair_time(dto.getRepair_time());
        res.setLoad_material(dto.getLoad_material());
        res.setLay_off(dto.getLay_off());
        res.setCleaning_time(dto.getCleaning_time());
        return res;
    }

    public DeviceDTO convertDomain2DTO(Device domain) {
        DeviceDTO res = new DeviceDTO();
        res.setId(domain.getId());
        res.setName(domain.getName());
        res.setModel(domain.getModel());
        res.setCredibility(domain.getCredibility());
        res.setCrafts(domain.getCrafts());
        res.setDescription(domain.getDescription());
        res.setValues(domain.getValues());
        res.setLongitude(domain.getLongitude());
        res.setLatitude(domain.getLatitude());
        res.setFailure_rate(domain.getFailure_rate());
        res.setRepair_time(domain.getRepair_time());
        res.setLoad_material(domain.getLoad_material());
        res.setLay_off(domain.getLay_off());
        res.setCleaning_time(domain.getCleaning_time());
        return res;
    }

    public Device convertPO2Domain(DevicePO po) {
        Device res = new Device();
        res.setId(po.getId());
        res.setName(po.getName());
        res.setModel(po.getModel());
        res.setCredibility(po.getCredibility());
        res.setCrafts(po.getCrafts());
        res.setDescription(po.getDescription());
        res.setValues(po.getValues());
        res.setLongitude(po.getLongitude());
        res.setLatitude(po.getLatitude());
        res.setFailure_rate(po.getFailure_rate());
        res.setRepair_time(po.getRepair_time());
        res.setLoad_material(po.getLoad_material());
        res.setLay_off(po.getLay_off());
        res.setCleaning_time(po.getCleaning_time());
        return res;
    }

    public DevicePO convertDomain2PO(Device domain) {
        DevicePO res = new DevicePO();
        res.setId(domain.getId());
        res.setName(domain.getName());
        res.setModel(domain.getModel());
        res.setCredibility(domain.getCredibility());
        res.setCrafts(domain.getCrafts());
        res.setDescription(domain.getDescription());
        res.setValues(domain.getValues());
        res.setLongitude(domain.getLongitude());
        res.setLatitude(domain.getLatitude());
        res.setFailure_rate(domain.getFailure_rate());
        res.setRepair_time(domain.getRepair_time());
        res.setLoad_material(domain.getLoad_material());
        res.setLay_off(domain.getLay_off());
        res.setCleaning_time(domain.getCleaning_time());
        return res;
    }
}
