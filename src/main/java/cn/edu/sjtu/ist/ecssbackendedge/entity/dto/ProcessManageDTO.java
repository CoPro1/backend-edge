package cn.edu.sjtu.ist.ecssbackendedge.entity.dto;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Status;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Step;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @brief 流程 dto
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Data
public class ProcessManageDTO {

    private String id;

    private String owner;

    private String name;

    private String bpmn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date createdTime;

    private Step step;

    private Status status;

    private Boolean flag;
}
