package cn.edu.sjtu.ist.ecssbackendedge.dao.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.ProcessManageDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.ProcessManage;
import cn.edu.sjtu.ist.ecssbackendedge.entity.po.ProcessManagePO;
import cn.edu.sjtu.ist.ecssbackendedge.repository.ProcessManageRepository;
import cn.edu.sjtu.ist.ecssbackendedge.utils.convert.ProcessManageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief 流程 daoImpl
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Slf4j
@Component
public class ProcessManageDaoImpl implements ProcessManageDao {

    @Autowired
    private ProcessManageUtil processManageUtil;

    @Autowired
    private ProcessManageRepository processManageRepository;

    @Override
    public void createProcess(ProcessManage processManage) {
        ProcessManagePO po = processManageUtil.convertDomain2PO(processManage);
        processManageRepository.save(po);
    }

    @Override
    public void removeProcess(String id) {
        processManageRepository.deleteProcessPOById(id);
    }

    @Override
    public void banProcess(String id) {
        ProcessManagePO po = processManageRepository.findProcessById(id);
        if (po != null) {
            Boolean flag = po.getFlag();
            if(flag) {
                po.setFlag(false);
                log.info("禁用id = {} 成功", id);
                processManageRepository.save(po);
            }
            else {
                log.info("禁用id = {} 失败", id);
            }
        }
    }

    @Override
    public void enableProcess(String id) {
        ProcessManagePO po = processManageRepository.findProcessById(id);
        if (po != null) {
            Boolean flag = po.getFlag();
            if(!flag) {
                po.setFlag(true);
                log.info("启用id = {} 成功", id);
                processManageRepository.save(po);
            }
            else {
                log.info("启用id = {} 失败", id);
            }
        }
    }

    @Override
    public void modifyProcess(ProcessManage processManage) {
        ProcessManagePO po = processManageRepository.findProcessById(processManage.getId());
        if (po != null) {
            po = processManageUtil.convertDomain2PO(processManage);
            processManageRepository.save(po);
        }
    }

    @Override
    public ProcessManage findProcessById(String id) {
        ProcessManagePO po = processManageRepository.findProcessById(id);
        ProcessManage processManage = processManageUtil.convertPO2Domain(po);
        log.info(String.valueOf(processManage));
        return processManage;
    }

    @Override
    public List<ProcessManage> findProcessByName(String name) {
        List<ProcessManagePO> processManagePOS = processManageRepository.findProcessPOSByName(name);
        List<ProcessManage> processManages = new ArrayList<>();
        for (ProcessManagePO processManagePO : processManagePOS) {
            ProcessManage dm = processManageUtil.convertPO2Domain(processManagePO);
            processManages.add(dm);
        }
        return processManages;
    }

    @Override
    public List<ProcessManage> findProcessesByOwner(String owner) {
        List<ProcessManagePO> processManagePOS = processManageRepository.findProcessPOSByOwner(owner);
        List<ProcessManage> processManages = new ArrayList<>();
        for (ProcessManagePO processManagePO : processManagePOS) {
            ProcessManage dm = processManageUtil.convertPO2Domain(processManagePO);
            processManages.add(dm);
        }
        return processManages;
    }

    @Override
    public List<ProcessManage> findAllProcesses() {
        List<ProcessManagePO> processManagePOS = processManageRepository.findAll();
        List<ProcessManage> processManages = new ArrayList<>();
        for (ProcessManagePO processManagePO : processManagePOS) {
            ProcessManage dm = processManageUtil.convertPO2Domain(processManagePO);
            processManages.add(dm);
        }
        return processManages;
    }
}
