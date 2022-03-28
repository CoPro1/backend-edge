package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.device.DeviceDTO;
import cn.edu.sjtu.ist.ecssbackendedge.service.DeviceService;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.Result;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.ResultUtil;

import com.github.yeecode.objectlogger.client.service.LogClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author rsp
 * @version 0.1
 * @brief 设备 Controller
 * @date 2021-10-23
 */
@Slf4j
@RestController
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private LogClient logClient;

    @PostMapping(value = "")
    public Result<DeviceDTO> insertDevice(@RequestBody DeviceDTO deviceDTO) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        logClient.logAttributes(
                "新增设备",
                "设备信息",
                "EdgeManager-9528",
                "add",
                "新增设备 【" + deviceDTO.getName() +"】",
                formatter.format(date),
                "设备信息 【" + deviceDTO +"】",
                null);
        return ResultUtil.success(deviceService.insertDevice(deviceDTO));
    }

    @DeleteMapping(value = "/{id}")
    public Result deleteDevice(@PathVariable String id) {
        DeviceDTO tmp = deviceService.getDevice(id);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        logClient.logAttributes(
                "删除设备",
                "设备信息",
                "EdgeManager-9528",
                "add",
                "新增设备 【" + tmp.getName() +"】",
                formatter.format(date),
                "设备信息 【" + tmp +"】",
                null);
        deviceService.deleteDevice(id);
        return ResultUtil.success();
    }

    @PutMapping(value = "/{id}")
    public Result<DeviceDTO> updateDevice(@PathVariable String id, @RequestBody DeviceDTO deviceDTO) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        logClient.logAttributes(
                "删除设备",
                "设备信息",
                "EdgeManager-9528",
                "add",
                "更新设备信息 【" + deviceDTO.getName() +"】",
                formatter.format(date),
                "设备信息 【" + deviceDTO +"】",
                null);
        return ResultUtil.success(deviceService.updateDevice(id, deviceDTO));
    }

    @GetMapping(value = "/{id}")
    public Result<DeviceDTO> getDevice(@PathVariable String id) {
        return ResultUtil.success(deviceService.getDevice(id));
    }

    @GetMapping(value = "")
    public Result<List<DeviceDTO>> getAllDevices() {
        System.out.println(ResultUtil.success(deviceService.getAllDevices()));
        return ResultUtil.success(deviceService.getAllDevices());
    }
}
