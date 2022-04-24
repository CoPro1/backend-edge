package cn.edu.sjtu.ist.ecssbackendedge.entity.znew;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.device.Device;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.device.DeviceDTO;
import lombok.Data;

import java.util.List;

@Data
public class TaskCraft {
    private String name;
    private List<String> craft_list;
}
