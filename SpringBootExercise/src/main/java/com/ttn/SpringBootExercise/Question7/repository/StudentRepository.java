package com.ttn.SpringBootExercise.Question7.repository;


import com.ttn.SpringBootExercise.Question7.entity.student1;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<student1,Integer> {

}

