package cn.edu.sjtu.ist.ecssbackendedge.service.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.MyTaskDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;
import cn.edu.sjtu.ist.ecssbackendedge.service.MyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTaskServiceImpl implements MyTaskService {
    @Autowired
    private MyTaskDao myTaskDao;

    @Override
    public List<MyTask> getAll() {
        return myTaskDao.getAll();
    }

    @Override
    public void addMyTask(CloudTaskInfo myTask) {
        myTaskDao.addMyTask(myTask);
    }

    @Override
    public Integer updateTaskState(Integer id, Integer TaskState){
        return myTaskDao.updateTaskState(id, TaskState);
    }

    @Override
    public  MyTask findById(Integer id){
        return myTaskDao.findById(id);
    }
}
