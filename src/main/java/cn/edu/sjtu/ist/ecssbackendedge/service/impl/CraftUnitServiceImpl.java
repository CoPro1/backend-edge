package cn.edu.sjtu.ist.ecssbackendedge.service.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.CraftUnitDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import cn.edu.sjtu.ist.ecssbackendedge.service.CraftUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zengyuxin
 */

@Slf4j
@Service
public class CraftUnitServiceImpl implements CraftUnitService {
    @Autowired
    private CraftUnitDao craftUnitDao;

    @Override
    public List<CraftUnit> getCraftUnits(){
        return craftUnitDao.getCraftUnits();
    }

    @Override
    public CraftUnit findOne(Integer id){
        return craftUnitDao.findOne(id);
    }

    @Override
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

    @Override
    public String checkCraftUnit(@RequestBody List<String> craft){
        int size = craft.size();
        for(int i = 0; i < size; i++){
            CraftUnit tmp = craftUnitDao.getCraftUnitByName(craft.get(i));
            if(tmp == null){
                System.out.println("not exists");
                return "工艺流程" + craft.get(i) +  "不存在";
            }
        }
        return "success";
    }
}
