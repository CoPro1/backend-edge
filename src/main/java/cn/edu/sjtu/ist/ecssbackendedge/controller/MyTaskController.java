package cn.edu.sjtu.ist.ecssbackendedge.controller;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;
import cn.edu.sjtu.ist.ecssbackendedge.service.MyTaskService;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.Result;
import cn.edu.sjtu.ist.ecssbackendedge.utils.response.ResultUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.yeecode.objectlogger.client.service.LogClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/my_task")
public class MyTaskController {
    @Autowired
    private MyTaskService myTaskService;

    @Autowired
    private LogClient logClient;

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
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        logClient.logAttributes(
                "新增任务",
                "任务信息",
                "EdgeManager-9531",
                task.getTask_id(),
                "收到任务 【" + task.getTask_id() +"】",
                formatter.format(date),
                "任务信息 【" + task +"】",
                null);
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
        Integer oldState = myTaskService.updateTaskState(id, taskState);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        MyTask t = myTaskService.findById(id);
        String statechange = "";
        switch (taskState) {
            case 3:{
                if(oldState.equals(1)) {
                    statechange = "开始生产";
                    break;
                }
                else if(oldState.equals(5)){
                    statechange = "继续生产";
                    break;
                }

            }
            case 5:{
                statechange = "暂停生产";
                break;
            }
            case 2:{
                statechange = "终止生产";
                break;
            }
            default:
                statechange = "任务状态发生改变";
        }
        logClient.logAttributes(
                "任务状态变更",
                "任务信息",
                "EdgeManager-9531",
                t.getTask_id(),
                "任务 【" + t.getTask_id() +"】" + statechange,
                formatter.format(date),
                statechange,
                null);
        return ResultUtil.success();
    }
}
