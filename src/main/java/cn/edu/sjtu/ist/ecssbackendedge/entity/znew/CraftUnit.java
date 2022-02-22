package cn.edu.sjtu.ist.ecssbackendedge.entity.znew;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

/**
 * @author zengyuxin
 */
@Data
@Entity
@Table(name = "craft_unit")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class CraftUnit {
    /**
     * 工艺单元的id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 工艺单元的名称
     */
    @Field
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
