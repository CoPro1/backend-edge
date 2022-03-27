package cn.edu.sjtu.ist.ecssbackendedge.entity.znew;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CloudTaskInfo {
    /**
     * 云端任务id
     */
    private String task_id;

    /**
     * 边端流程名称
     */
    private String pro_name;

    /**
     * 任务执行次数
     */
    private Integer times;

    /**
     * 任务执行ddl
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp deadline;

    /**
     * 下一条边
     */
    private String next_edge;

    /**
     * 任务描述
     */
    private String description;
}
