package cn.edu.sjtu.ist.ecssbackendedge.service;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.ProcessManage;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Step;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.ProcessManageDTO;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.List;

/**
 * @brief 流程 service
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
public interface ProcessManageService {

    ProcessManage insertProcess(ProcessManage processManage);

    ProcessManage insertProcessWithFile(ProcessManage processManage, MultipartFile file);

    void deleteProcess(String id);

    void banProcess(String id);

    void enableProcess(String id);

    void updateProcess(String id, ProcessManage processManage);

    List<ProcessManage> getAllProcessesByUser(String userId);

    List<ProcessManage> getAllProcesses();

    void updateProcessBpmn(String processId, MultipartFile file);

    void updateProcessStep(String processId, Step step);

    void updateProcessName(String processId, String name);

    ProcessManage findProcess(String processId);

    List<ProcessManage> findOwnedProcesses(String owner);

    String findBpmn(String processId);

    List<String> findBpmnEvents(String processId);

    Boolean issueProcess(String ip, String port, ProcessManageDTO processManageDTO);

}