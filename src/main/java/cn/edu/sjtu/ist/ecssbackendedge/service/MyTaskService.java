package cn.edu.sjtu.ist.ecssbackendedge.service;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;

import java.util.List;

public interface MyTaskService {
    List<MyTask> getAll();

    void addMyTask(CloudTaskInfo myTask);

}
