package cn.edu.sjtu.ist.ecssbackendedge.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueProcessManageRequest {

    private ProcessManageDTO processManageDTO;

    private String ip;

    private String port;

}
