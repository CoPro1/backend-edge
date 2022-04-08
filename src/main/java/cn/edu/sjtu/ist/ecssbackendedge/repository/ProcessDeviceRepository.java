package cn.edu.sjtu.ist.ecssbackendedge.repository;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.ProcessDevice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProcessDeviceRepository extends MongoRepository<ProcessDevice, String> {
    List<ProcessDevice> findAll();

    ProcessDevice  findFirstByCraftName(String id);

}
