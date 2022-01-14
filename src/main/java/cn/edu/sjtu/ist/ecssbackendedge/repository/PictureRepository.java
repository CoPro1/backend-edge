package cn.edu.sjtu.ist.ecssbackendedge.repository;

import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.machineLearning.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

/**
 * @author dyanjun
 * @date 2022/1/14 8:39
 */
public interface PictureRepository extends MongoRepository<Picture, String> {
    List<Picture> findAll();
    List<Picture> findPicturesByMlModalId(String id);
}
