package cn.edu.sjtu.ist.ecssbackendedge.dao;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zengyuxin
 */
public interface CraftUnitDao {

    List<CraftUnit> getCraftUnits();

    CraftUnit findOne(Integer id);

    void addCraftUnit(String name);

    CraftUnit getCraftUnitByName(String name);
}
