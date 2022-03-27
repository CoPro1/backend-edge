package cn.edu.sjtu.ist.ecssbackendedge.service;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zengyuxin
 */

public interface CraftUnitService {
    List<CraftUnit> getCraftUnits();

     CraftUnit findOne(Integer id);

     String addCraftUnit(String name);

    String checkCraftUnit(@RequestBody List<String> craft);

}
