package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import cn.edu.sjtu.ist.ecssbackendedge.service.CraftUnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zengyuxin
 */

@Slf4j
@RestController
@RequestMapping(value = "/craft")
public class CraftUnitController {
    @Autowired
    private CraftUnitService craftUnitService;

    @PostMapping(value = "addCraftUnit/{name}")
    public String addCraftUnit(@PathVariable String name) {
        System.out.println("controller"+name);
        return craftUnitService.addCraftUnit(name);
    }

    @GetMapping(value = "/{id}")
    public CraftUnit findOne(@PathVariable Integer id) {
        return craftUnitService.findOne(id);
    }

    @GetMapping(value = "")
    public List<CraftUnit> getAllDevices() {
        System.out.println(craftUnitService.getCraftUnits());
        return craftUnitService.getCraftUnits();
    }

}
