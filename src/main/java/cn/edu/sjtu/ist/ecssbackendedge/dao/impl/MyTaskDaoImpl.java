package cn.edu.sjtu.ist.ecssbackendedge.dao.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.MyTaskDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;
import cn.edu.sjtu.ist.ecssbackendedge.repository.MyTaskRepository;
import cn.edu.sjtu.ist.ecssbackendedge.utils.convert.TaskUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MyTaskDaoImpl implements MyTaskDao {
    @Autowired
    private MyTaskRepository myTaskRepository;

//    @Autowired
//    private TaskStateRepository taskStateRepository;

    @Autowired
    private TaskUtil taskUtil;


    @Override
    public List<MyTask> getAll() {
        return myTaskRepository.findAll();
    }

//    @Override
//    public List<MyTask> getMyTasks() {
//        List<MyTask> res= myTaskRepository.getMyTasks();
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.addAll(res);
//        List<MyTaskRes> list = jsonArray.toJavaList(MyTaskRes.class);
//        log.info(String.valueOf(list));
//        return list;
//    }

    @Override
    public void addMyTask(CloudTaskInfo cloudTaskInfo) {
        MyTask tmpTask = taskUtil.convertCT2MT(cloudTaskInfo);
        tmpTask.setState(0);
        log.info(String.valueOf(tmpTask));
        myTaskRepository.save(tmpTask);
    }
}
