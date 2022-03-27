package cn.edu.sjtu.ist.ecssbackendedge.entity.dto.device;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.command.Command;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.device.DataEntry;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnitInfo;
import lombok.Data;

import javax.xml.stream.Location;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author rsp
 * @version 0.1
 * @brief 设备DTO
 * @date 2021-11-08
 */
@Data
public class DeviceDTO {

    /**
     * 设备id
     */
    private String id;
    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备型号
     */
    private String model;

    /**
     * @author zengyuxin
     * 设备信任度
     */
    private Integer credibility;

    /**
     * @author zengyuxin
     * 工艺单元
     */
    private List<CraftUnitInfo> crafts;

    /**
     * 设备描述，可有可无
     */
    private String description;

    /**
     * 设备的数据项列表
     */
    private List<DataEntry> values;

    /**
     * @author zengyuxin
     * 设备位置
     */
    private BigDecimal longitude;
    private BigDecimal latitude;

    /**
     * @author zengyuxin
     * 故障率 故障恢复时间
     */
    private Integer failure_rate;
    private Integer repair_time;

    /**
     * @author zengyuxin
     * 设备上下料时间
     */
    private Integer load_material;
    private Integer lay_off;

    /**
     * @author zengyuxin
     * 设备清洗时间
     */
    private Integer cleaning_time;

}
