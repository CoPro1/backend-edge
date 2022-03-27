package cn.edu.sjtu.ist.ecssbackendedge.dao;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;

import java.util.List;

public interface MyTaskDao {
    List<MyTask> getAll();

    void addMyTask(CloudTaskInfo myTask);

//    List<MyTask> getMyTasks();
}
