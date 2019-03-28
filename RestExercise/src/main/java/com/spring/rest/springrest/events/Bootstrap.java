package com.spring.rest.springrest.events;

import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Bootstrap {


    @Autowired
    StudentRepository studentRepository;

    @EventListener(ContextRefreshedEvent.class)
    void setUp(){


        if(!studentRepository.findAll().iterator().hasNext()) {
            IntStream.range(0, 10).forEach(e -> {
                Student student = new Student();
                student.setAge(20 + e);
                student.setCity("City"+e);
                student.setName("name" + e);
                student.setPercentage(60+e);
                student.setStandard(e+"nd");
                studentRepository.save(student);
            });
        }


    }

}
