package cn.edu.sjtu.ist.ecssbackendedge.entity.znew;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author zengyuxin
 */
@Data
@Entity
@Table(name = "my_task")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class MyTask {
    /**
     * 任务的id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 所属用户id
     */
    @Field
    private Integer user_id;

    /**
     * 云端任务id
     */
    @Field
    private String task_id;

    /**
     * 边端流程名称
     */
    @Field
    private String pro_name;

    /**
     * 任务执行次数
     */
    @Field
    private Integer times;

    /**
     * 任务到达时间
     */
    @Field
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp arrive_time;

    /**
     * 任务执行ddl
     */
    @Field
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp deadline;

    /**
     * 下一个边
     */
    @Field
    private String next_edge;

    /**
     * 任务描述
     */
    @Field
    private String description;

    /**
     * 任务状态
     */
    @Field
    private Integer state;


}
