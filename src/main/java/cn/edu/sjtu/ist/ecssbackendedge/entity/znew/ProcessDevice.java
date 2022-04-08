package cn.edu.sjtu.ist.ecssbackendedge.entity.znew;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.List;

@Data
@Document("process_device")
public class ProcessDevice {
    @Field
    private String id;

    @Field
    private String craftName;

    @Field
    private List<MachineInfo> machines;
}
