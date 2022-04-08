package cn.edu.sjtu.ist.ecssbackendedge.service;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.ProcessDevice;

import java.util.List;

public interface ProcessDeviceService {
    List<ProcessDevice> findAll();

    ProcessDevice findByCraftName(String name);
}
