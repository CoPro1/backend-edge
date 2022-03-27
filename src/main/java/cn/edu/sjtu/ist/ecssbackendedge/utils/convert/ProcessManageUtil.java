package cn.edu.sjtu.ist.ecssbackendedge.utils.convert;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.ProcessManage;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.ProcessManageDTO;
import cn.edu.sjtu.ist.ecssbackendedge.entity.po.ProcessManagePO;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @brief 流程类转换工具类
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Component
public class ProcessManageUtil {

    public ProcessManage convertDTO2Domain(ProcessManageDTO dto) {
        ProcessManage res = new ProcessManage();
        res.setId(dto.getId());
        res.setOwner(dto.getOwner());
        res.setName(dto.getName());
        res.setBpmn(dto.getBpmn());
        res.setStep(dto.getStep());
        res.setStatus(dto.getStatus());
        res.setFlag(dto.getFlag());
        res.setCreatedTime(dto.getCreatedTime() == null ? new Date() : dto.getCreatedTime());
        return res;
    }

    public ProcessManageDTO convertDomain2DTO(ProcessManage domain) {
        ProcessManageDTO res = new ProcessManageDTO();
        res.setId(domain.getId());
        res.setOwner(domain.getOwner());
        res.setName(domain.getName());
        res.setBpmn(domain.getBpmn());
        res.setStep(domain.getStep());
        res.setStatus(domain.getStatus());
        res.setFlag(domain.getFlag());
        res.setCreatedTime(domain.getCreatedTime() == null ? new Date() : domain.getCreatedTime());
        return res;
    }

    public ProcessManage convertPO2Domain(ProcessManagePO po) {
        ProcessManage res = new ProcessManage();
        res.setId(po.getId());
        res.setOwner(po.getOwner());
        res.setName(po.getName());
        res.setBpmn(po.getBpmn());
        res.setStep(po.getStep());
        res.setStatus(po.getStatus());
        res.setFlag(po.getFlag());
        res.setCreatedTime(po.getCreatedTime() == null ? new Date() : po.getCreatedTime());
        return res;
    }

    public ProcessManagePO convertDomain2PO(ProcessManage domain) {
        ProcessManagePO res = new ProcessManagePO();
        res.setId(domain.getId());
        res.setOwner(domain.getOwner());
        res.setName(domain.getName());
        res.setBpmn(domain.getBpmn());
        res.setStep(domain.getStep());
        res.setStatus(domain.getStatus());
        res.setFlag(domain.getFlag());
        res.setCreatedTime(domain.getCreatedTime() == null ? new Date() : domain.getCreatedTime());
        return res;
    }
}