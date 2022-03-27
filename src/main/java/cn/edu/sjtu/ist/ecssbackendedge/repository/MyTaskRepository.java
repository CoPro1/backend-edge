package cn.edu.sjtu.ist.ecssbackendedge.repository;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTaskRepository extends JpaRepository<MyTask,Integer> {
//    @Query(value = "select * from edge.my_task natural join edge.task_state", nativeQuery = true)
//    List<Map<String, Object>> getMyTasks();

}
