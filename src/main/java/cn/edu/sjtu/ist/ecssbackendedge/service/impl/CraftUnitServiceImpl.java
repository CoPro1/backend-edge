package cn.edu.sjtu.ist.ecssbackendedge.service.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.CraftUnitDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import cn.edu.sjtu.ist.ecssbackendedge.service.CraftUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zengyuxin
 */

@Slf4j
@Service
public class CraftUnitServiceImpl implements CraftUnitService {
    @Autowired
    private CraftUnitDao craftUnitDao;

    public List<CraftUnit> getCraftUnits(){
        return craftUnitDao.getCraftUnits();
    }

    public CraftUnit findOne(Integer id){
        return craftUnitDao.findOne(id);
    }

    public String addCraftUnit(String name){
        CraftUnit tmp = craftUnitDao.getCraftUnitByName(name);
        System.out.println(tmp);
        if(tmp == null){
            System.out.println("service"+name);
            craftUnitDao.addCraftUnit(name);
            return "success";
        }
        else {
            return "already exists";
        }

    }
}
