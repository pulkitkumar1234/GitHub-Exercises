package com.ReapWebFinal.ReapWebFinal.repository;

import com.ReapWebFinal.ReapWebFinal.entity.Employee;
import com.ReapWebFinal.ReapWebFinal.entity.WallOfFame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WallOfFameRepository extends CrudRepository<WallOfFame,Integer> {

    List<WallOfFame> findAllByGiverId(Integer id);
    List<WallOfFame> findAllByReceiverId(Integer Id);
    List<WallOfFame> findAllById(Integer id);
    List<WallOfFame> findAllByReceiverIdOrGiverId(Integer id,Integer id1);
   // List<WallOfFame> findAll();
}
