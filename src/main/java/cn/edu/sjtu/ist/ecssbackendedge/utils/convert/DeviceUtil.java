package cn.edu.sjtu.ist.ecssbackendedge.utils.convert;

import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.DeviceDTO;
import cn.edu.sjtu.ist.ecssbackendedge.entity.po.DevicePO;
import cn.edu.sjtu.ist.ecssbackendedge.model.device.Device;
import org.springframework.stereotype.Component;

/**
 * @brief 设备对象转换工具类
 * @author rsp
 * @version 0.1
 * @date 2021-11-20
 */
@Component
public class DeviceUtil {

    public Device convertDTO2Domain(DeviceDTO dto) {
        Device res = new Device();
        res.setId(dto.getId());
        res.setName(dto.getName());
        res.setModel(dto.getModel());
        res.setDescription(dto.getDescription());
        res.setValues(dto.getValues());
        System.out.println(res);
        return res;
    }

    public DeviceDTO convertDomain2DTO(Device domain) {
        DeviceDTO res = new DeviceDTO();
        res.setId(domain.getId());
        res.setName(domain.getName());
        res.setModel(domain.getModel());
        res.setDescription(domain.getDescription());
        res.setValues(domain.getValues());
        System.out.println(res);
        return res;
    }

    public Device convertPO2Domain(DevicePO po) {
        System.out.println(po);
        Device res = new Device();
        res.setId(po.getId());
        res.setName(po.getName());
        res.setModel(po.getModel());
        res.setDescription(po.getDescription());
        res.setValues(po.getValues());
        System.out.println(res);
        return res;
    }

    public DevicePO convertDomain2PO(Device domain) {
        DevicePO res = new DevicePO();
        res.setId(domain.getId());
        res.setName(domain.getName());
        res.setModel(domain.getModel());
        res.setDescription(domain.getDescription());
        res.setValues(domain.getValues());
        System.out.println(res);
        return res;
    }
}
