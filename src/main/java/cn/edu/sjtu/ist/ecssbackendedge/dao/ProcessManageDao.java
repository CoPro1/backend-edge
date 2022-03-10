package cn.edu.sjtu.ist.ecssbackendedge.dao;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.ProcessManage;

import java.util.List;

/**
 * @brief 流程 dao
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
public interface ProcessManageDao {

    void createProcess(ProcessManage processManage);

    void removeProcess(String id);

    void banProcess(String id);

    void enableProcess(String id);

    void modifyProcess(ProcessManage processManage);

    ProcessManage findProcessById(String id);

    List<ProcessManage> findProcessByName(String name);

    List<ProcessManage> findProcessesByOwner(String owner);

    List<ProcessManage> findAllProcesses();
}
