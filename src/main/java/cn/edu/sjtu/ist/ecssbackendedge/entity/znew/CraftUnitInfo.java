package cn.edu.sjtu.ist.ecssbackendedge.entity.znew;

import lombok.Data;

@Data
public class CraftUnitInfo {
    /**
     * 工艺流程的名称
     */
    private String name;

    /**
     * 工艺流程对应所需时间
     */
    private Integer time;

}
