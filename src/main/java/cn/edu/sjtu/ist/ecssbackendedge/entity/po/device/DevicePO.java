package cn.edu.sjtu.ist.ecssbackendedge.entity.po.device;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.command.Command;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.device.DataEntry;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnitInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author rsp
 * @version 0.1
 * @brief 设备PO
 * @date 2021-11-08
 */
@Data
@Document(collection = "device")
public class DevicePO {

    /**
     * 设备id
     */
    @Id
    private String id;

    /**
     * 设备名称
     */
    @Field
    private String name;

    /**
     * 设备型号
     */
    @Field
    private String model;

    /**
     * @author zengyuxin
     * 设备信任度
     */
    @Field
    private Integer credibility;

    /**
     * 设备描述，可有可无
     */
    @Field
    private String description;

    /**
     * @author zengyuxin
     * 工艺单元
     */
    @Field
    private List<CraftUnitInfo> crafts;

    /**
     * 设备的数据项列表
     */
    @Field
    private List<DataEntry> values;

    /**
     * @author zengyuxin
     * 设备位置
     */
    @Field
    private BigDecimal longitude;

    @Field
    private BigDecimal latitude;

    /**
     * @author zengyuxin
     * 故障率 故障恢复时间
     */
    @Field
    private Integer failure_rate;

    @Field
    private Integer repair_time;

    /**
     * @author zengyuxin
     * 设备上下料时间
     */
    @Field
    private Integer load_material;

    @Field
    private Integer lay_off;

    /**
     * @author zengyuxin
     * 设备清洗时间
     */
    @Field
    private Integer cleaning_time;

    /**
     * 设备的命令项列表
     */
    @Field
    private List<Command> commands;
}
