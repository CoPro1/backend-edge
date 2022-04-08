package cn.edu.sjtu.ist.ecssbackendedge.dao;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.ProcessDevice;

import java.util.List;

public interface ProcessDeviceDao {
    List<ProcessDevice> findAll();

    ProcessDevice findByCraftName(String name);
}
