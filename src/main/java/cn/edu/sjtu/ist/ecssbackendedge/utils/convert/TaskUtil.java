package cn.edu.sjtu.ist.ecssbackendedge.utils.convert;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CloudTaskInfo;
import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zengyuxin
 */
@Component
public class TaskUtil {
    public CloudTaskInfo convertMT2CT(MyTask tmp) {
        CloudTaskInfo res = new CloudTaskInfo();
        res.setTask_id(tmp.getTask_id());
        res.setPro_name(tmp.getPro_name());
        res.setTimes(tmp.getTimes());
        res.setDeadline(tmp.getDeadline());
        res.setNext_edge(tmp.getNext_edge());
        res.setDescription(tmp.getDescription());
        return res;
    }

    public MyTask convertCT2MT(CloudTaskInfo tmp) {
        MyTask res = new MyTask();
        res.setTask_id(tmp.getTask_id());
        res.setPro_name(tmp.getPro_name());
        res.setTimes(tmp.getTimes());
        res.setDeadline(tmp.getDeadline());
        res.setNext_edge(tmp.getNext_edge());
        res.setDescription(tmp.getDescription());
        java.util.Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());//将时间转换成Timestamp类型，这样便可以存入到Mysql数据库中
        res.setArrive_time(t);
        return res;
    }
}
