package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.ProcessManageRequest;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.ProcessManage;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Status;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Step;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.IssueProcessManageRequest;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.ProcessManageDTO;
import cn.edu.sjtu.ist.ecssbackendedge.service.ProcessManageService;
import cn.edu.sjtu.ist.ecssbackendedge.utils.convert.ProcessManageUtil;
import cn.edu.sjtu.ist.ecssbackendedge.utils.process.BpmnUtils;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.Result;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @brief 流程controller
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Slf4j
@RestController
@RequestMapping(value = "/process-manage")
public class ProcessManageController {

    @Autowired
    private ProcessManageService processManageService;

    @Autowired
    private ProcessManageUtil processManageUtil;

    @PostMapping(value = "")
    public Result<?> insertProcessWithFile(@ModelAttribute ProcessManageRequest request) {
        String name = request.getName();
        String owner = request.getOwner();
        MultipartFile file = request.getFile();
        ProcessManageDTO dto = new ProcessManageDTO();
        dto.setOwner(owner);
        dto.setName(name);
        dto.setBpmn(BpmnUtils.multiFileToStr(file));
        dto.setCreatedTime(new Date());
        dto.setStep(Step.BPMN);
        dto.setStatus(Status.CONSTRUCTING);
        dto.setFlag(true);
        ProcessManage processManage = processManageUtil.convertDTO2Domain(dto);
        try {
            return ResultUtil.success(processManageService.insertProcess(processManage));
        } catch (RuntimeException exception) {
            return ResultUtil.failure("该名称已存在", HttpStatus.EXPECTATION_FAILED.value());
        }

    }

    @DeleteMapping(value = "/{id}")
    public Result<?> deleteProcess(@PathVariable String id) {
        processManageService.deleteProcess(id);
        return ResultUtil.success();
    }

    @PostMapping(value = "/ban/{id}")
    public Result<?> banProcess(@PathVariable String id) {
        processManageService.banProcess(id);
        return ResultUtil.success();
    }

    @PostMapping(value = "/enable/{id}")
    public Result<?> enableProcess(@PathVariable String id) {
        processManageService.enableProcess(id);
        return ResultUtil.success();
    }

    @PutMapping(value = "/{id}")
    public Result<?> updateProcess(@PathVariable String id, @RequestBody ProcessManageDTO dto) {
        ProcessManage processManage = processManageUtil.convertDTO2Domain(dto);
        processManageService.updateProcess(id, processManage);
        return ResultUtil.success();
    }

    @GetMapping(value = "/{id}")
    public Result<?> findProcess(@PathVariable("id") String id) {
        return ResultUtil.success(processManageService.findProcess(id));
    }

    @GetMapping(value = "/user/{userId}")
    public Result<?> getAllProcessesByUser(@PathVariable("userId") String userId) {
        return ResultUtil.success(processManageService.getAllProcessesByUser(userId));
    }

    @GetMapping(value = "")
    public Result<?> getAllProcesses() {
        return ResultUtil.success(processManageService.getAllProcesses());
    }

    @PutMapping("/{id}/step/{step}")
    public Result<?> updateProcessStep(@PathVariable String id, @PathVariable String step) {
        processManageService.updateProcessStep(id, Step.valueOf(step));
        return ResultUtil.success();
    }

    @PutMapping(value = "/{id}/name/{name}")
    public Result<?> updateProcessName(@PathVariable String id, @PathVariable String name) {
        processManageService.updateProcessName(id, name);
        return ResultUtil.success();
    }

    @GetMapping(value = "/owner/{owner}")
    public Result<?> findAllProcess(@PathVariable String owner) {
        return ResultUtil.success(processManageService.findOwnedProcesses(owner));
    }

    @GetMapping("/{id}/bpmn")
    public Result<String> findBpmn(@PathVariable String id) {
        return ResultUtil.success(processManageService.findBpmn(id));
    }

    @PutMapping("/{id}/bpmn")
    public Result<?> updateBpmn(@PathVariable String id, @RequestParam("file") MultipartFile file) {
        processManageService.updateProcessBpmn(id, file);
        return ResultUtil.success();
    }

    @PostMapping("/issue")
    public Result<?> issueProcess(@RequestBody IssueProcessManageRequest issueProcessManageRequest) {
        System.out.println(issueProcessManageRequest.getIp());
        System.out.println(issueProcessManageRequest.getProcessManageDTO());
        Boolean result = processManageService.issueProcess(issueProcessManageRequest.getIp(), issueProcessManageRequest.getPort(),
                issueProcessManageRequest.getProcessManageDTO());
        if (result == true) {
            return ResultUtil.success(true);
        } else {
            return ResultUtil.failure("Fail to issue the process to edge end.", HttpStatus.EXPECTATION_FAILED.value());
        }
    }

}
