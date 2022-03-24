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

    @Autowired
    private TaskUtil taskUtil;


    @Override
    public List<MyTask> getAll() {
        return myTaskRepository.findAll();
    }


    @Override
    public void addMyTask(CloudTaskInfo cloudTaskInfo) {
        MyTask tmpTask = taskUtil.convertCT2MT(cloudTaskInfo);
        tmpTask.setState(0);
        log.info(String.valueOf(tmpTask));
        myTaskRepository.save(tmpTask);
    }

    @Override
    public void updateTaskState(Integer id, Integer TaskState){
        MyTask tmp = myTaskRepository.getById(id);
        tmp.setState(TaskState);
        myTaskRepository.save(tmp);
    }
}
