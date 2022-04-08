package cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.proxy.BpmnModelProxy;
import cn.edu.sjtu.ist.ecssbackendedge.utils.process.BpmnUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @brief 流程领域模型
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Data
public class ProcessManage {

    private String id;

    /**
     * 与边端 id 对应
     */
    private String owner;

    private String name;

    private String bpmn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Date createdTime;

    private Step step = Step.BPMN;

    private Status status = Status.CONSTRUCTING;

    private Boolean flag;

    private List<String> craft_list;

    public void verifySelf() {
        BpmnModelProxy bpmnModelProxy = BpmnModelProxy.fromStream(BpmnUtils.strToInStream(this.bpmn));
        bpmnModelProxy.verifySelf();
    }
}
