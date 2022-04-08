package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.ProcessManageRequest;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.device.DeviceDTO;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MachineInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.ProcessDevice;
import cn.edu.sjtu.ist.ecssbackendedge.service.DeviceService;
import cn.edu.sjtu.ist.ecssbackendedge.service.ProcessDeviceService;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.Result;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.ResultUtil;
import com.github.yeecode.objectlogger.client.service.LogClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/process-device")
public class ProcessDeviceController {
    @Autowired
    private ProcessDeviceService processDeviceService;

    @Autowired
    private DeviceService deviceService;

    @GetMapping(value = "")
    public Result<?> findAll() {
        return ResultUtil.success(processDeviceService.findAll());
    }

    @GetMapping(value = "/name/{name}")
    public Result<?> findByCraftName(@PathVariable String name) {
        ProcessDevice processDevice = processDeviceService.findByCraftName(name);
        System.out.println(processDevice.toString());
        List<MachineInfo> deviceIds = processDevice.getMachines();
        System.out.println(deviceIds.toString());
        List<DeviceDTO> res = new ArrayList<>();
        for(MachineInfo machine : deviceIds) {
            String id = machine.getMachine_id();
            DeviceDTO tmp = deviceService.getDevice(id);
            System.out.println(tmp.toString());
            res.add(tmp);
        }
        System.out.println(res.toString());
        return ResultUtil.success(res);
    }
}
