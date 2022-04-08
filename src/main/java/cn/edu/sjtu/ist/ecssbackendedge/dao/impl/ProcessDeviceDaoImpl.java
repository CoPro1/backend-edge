package cn.edu.sjtu.ist.ecssbackendedge.dao.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.ProcessDeviceDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.ProcessDevice;
import cn.edu.sjtu.ist.ecssbackendedge.repository.ProcessDeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProcessDeviceDaoImpl implements ProcessDeviceDao {
    @Autowired
    private ProcessDeviceRepository processDeviceRepository;

    @Override
    public List<ProcessDevice> findAll() {
        List<ProcessDevice> res = processDeviceRepository.findAll();
        System.out.println(res.toString());
        return res;
    }

    @Override
    public ProcessDevice findByCraftName(String name) {
        return processDeviceRepository.findFirstByCraftName(name);
    }
}
