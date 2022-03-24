package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;
import cn.edu.sjtu.ist.ecssbackendedge.service.MyTaskService;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.Result;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/my_task")
public class MyTaskController {
    @Autowired
    private MyTaskService myTaskService;

    /**
     * 获取所有任务
     * @return List<MyTask>
     */
    @GetMapping(value = "")
    public List<MyTask> getAll() {
        List<MyTask> res = myTaskService.getAll();
        log.info(String.valueOf(res));
        return res;
    }

    /**
     * 添加任务
     */
    @PostMapping(value = "")
    public Result<?> addTask(@RequestBody CloudTaskInfo task) {
        myTaskService.addMyTask(task);
        log.info(String.valueOf(task));
        return ResultUtil.success();
    }

    /**
     * 添加任务
     */
    @PostMapping(value = "updateState")
    public Result<?> updateTaskState(@RequestBody Map<String, Integer> paramsMap) {
        Integer id = paramsMap.get("id");
        Integer taskState = paramsMap.get("newState");
        myTaskService.updateTaskState(id, taskState);
        return ResultUtil.success();
    }
}
