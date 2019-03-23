package com.ttn.SpringBootExercise.Question7;

import com.ttn.SpringBootExercise.Question7.entity.student1;
import com.ttn.SpringBootExercise.Question7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class Student1Service {

    @Autowired
    StudentRepository studentRepository;

    public List<student1> getStudent(){
        List<student1> list = new ArrayList<>();
        Iterator<student1> iterator = studentRepository.findAll().iterator();
        iterator.forEachRemaining(list::add);
        return list;
    }
}
