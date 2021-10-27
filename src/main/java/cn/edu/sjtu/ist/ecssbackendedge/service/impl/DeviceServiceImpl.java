package cn.edu.sjtu.ist.ecssbackendedge.service.impl;

import cn.edu.sjtu.ist.ecssbackendedge.entity.ddo.DeviceModel;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.Device;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.Response;
import cn.edu.sjtu.ist.ecssbackendedge.service.DeviceService;
import cn.edu.sjtu.ist.ecssbackendedge.dao.DeviceDao;
import cn.edu.sjtu.ist.ecssbackendedge.utils.MessageProtocol;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    @Override
    public Response insertDevice(Device device) {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setName(device.getName());
        deviceModel.setModel(device.getModel());
        log.info(Objects.requireNonNull(MessageProtocol.fromString(device.getMessageProtocol())).getProtocol());
        deviceModel.setMessageProtocol(MessageProtocol.fromString(device.getMessageProtocol()));
        deviceDao.createDevice(deviceModel);
        return new Response(200, "OK", "insert ok!");
    }

    @Override
    public Response deleteDevice(Long id) {
        deviceDao.removeDevice(id);
        return new Response(200, "OK", "delete ok!");
    }

    @Override
    public Response updateDevice(Long id, Device device) {
        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setId(id);
        deviceModel.setName(device.getName());
        deviceModel.setModel(device.getModel());
        deviceModel.setMessageProtocol(MessageProtocol.fromString(device.getMessageProtocol()));
        deviceDao.modifyDevice(deviceModel);
        return new Response(200, "OK", "update ok!");
    }

    @Override
    public Response getDevice(Long id) {
        DeviceModel deviceModel = deviceDao.findDeviceById(id);
        Device device = new Device();
        device.setId(deviceModel.getId());
        device.setName(deviceModel.getName());
        device.setModel(deviceModel.getModel());
        device.setMessageProtocol(deviceModel.getMessageProtocol().getProtocol());
        return new Response(200, "OK", device);
    }
}
