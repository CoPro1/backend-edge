package cn.edu.sjtu.ist.ecssbackendedge.service.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.ProcessDeviceDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.ProcessDevice;
import cn.edu.sjtu.ist.ecssbackendedge.service.ProcessDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessDeviceServiceImpl implements ProcessDeviceService {
    @Autowired
    private ProcessDeviceDao processDeviceDao;

    @Override
    public List<ProcessDevice> findAll() {
        return processDeviceDao.findAll();
    }

    @Override
    public ProcessDevice findByCraftName(String name) {
        return processDeviceDao.findByCraftName(name);
    }
}
