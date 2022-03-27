package cn.edu.sjtu.ist.ecssbackendedge.dao.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.CraftUnitDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import cn.edu.sjtu.ist.ecssbackendedge.repository.CraftUnitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zengyuxin
 */

@Slf4j
@Component
public class CraftUnitDaoImpl implements CraftUnitDao {
    @Autowired
    private CraftUnitRepository craftUnitRepository;

    @Override
    public CraftUnit findOne(Integer id){
        return craftUnitRepository.getById(id);
    }


    @Override
    public List<CraftUnit> getCraftUnits() {
        return craftUnitRepository.getCraftUnits();
    }

    @Override
    public void addCraftUnit(String name){
        System.out.println("dao"+name);
        craftUnitRepository.addCraftUnit(name);
    }

    @Override
    public CraftUnit getCraftUnitByName(String name){
        return craftUnitRepository.getCraftUnitByName(name);
    }
}
