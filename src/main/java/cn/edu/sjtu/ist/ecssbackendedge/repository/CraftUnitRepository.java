package cn.edu.sjtu.ist.ecssbackendedge.repository;

import cn.edu.sjtu.ist.ecssbackendedge.entity.znew.CraftUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository
public interface CraftUnitRepository extends JpaRepository<CraftUnit,Integer> {
    @Query("select b from CraftUnit b")
    List<CraftUnit> getCraftUnits();

    @Query("select b from CraftUnit b WHERE b.name = ?1")
    CraftUnit getCraftUnitByName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "insert into edge.craft_unit(name) values (?1)", nativeQuery = true)
    void addCraftUnit(@Param("name") String name);
}
