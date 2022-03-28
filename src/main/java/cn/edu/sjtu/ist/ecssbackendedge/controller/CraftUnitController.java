package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import cn.edu.sjtu.ist.ecssbackendedge.service.CraftUnitService;
import com.github.yeecode.objectlogger.client.service.LogClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private LogClient logClient;

    @PostMapping(value = "addCraftUnit/{name}")
    public String addCraftUnit(@PathVariable String name) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        logClient.logAttributes(
                "添加工艺单元",
                "工艺单元",
                "EdgeManager-9527",
                "add",
                "添加工艺单元 【" + name +"】",
                formatter.format(date),
                "Add a new craft 【" + name +"】",
                null);
        return craftUnitService.addCraftUnit(name);
    }

    @GetMapping(value = "checkCraftUnit/{name}")
    public String checkOneCraftUnit(@PathVariable String name) {
        System.out.println("controller"+name);
        List<String> tmp = new ArrayList<>();
        tmp.add(name);
        return craftUnitService.checkCraftUnit(tmp);
    }

    @GetMapping ("checkCraftUnit")
    public String checkCraftUnit(@RequestBody List<String> craft) {
        System.out.println(craft);
        return craftUnitService.checkCraftUnit(craft);
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
