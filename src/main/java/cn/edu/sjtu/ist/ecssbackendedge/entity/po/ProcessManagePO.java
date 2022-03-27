package cn.edu.sjtu.ist.ecssbackendedge.entity.po;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Status;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Step;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;

/**
 * @brief 流程 po
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Data
@Document("process-manage")
public class ProcessManagePO {

    @Id
    private String id;

    @Field
    private String owner;

    @Field
    private String name;

    @Field
    private String bpmn;

    @Field
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date createdTime;

    @Field
    private Step step;

    @Field
    private Status status;

    @Field
    private Boolean flag;
}