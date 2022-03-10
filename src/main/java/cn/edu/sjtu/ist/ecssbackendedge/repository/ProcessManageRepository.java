package cn.edu.sjtu.ist.ecssbackendedge.repository;


import cn.edu.sjtu.ist.ecssbackendedge.entity.po.ProcessManagePO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @brief 流程 repository
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
public interface ProcessManageRepository extends MongoRepository<ProcessManagePO, String> {

    void deleteProcessPOById(String id);

    ProcessManagePO findProcessById(String id);

    List<ProcessManagePO> findProcessPOSByName(String name);

    List<ProcessManagePO> findProcessPOSByOwner(String owner);

    List<ProcessManagePO> findAll();

}