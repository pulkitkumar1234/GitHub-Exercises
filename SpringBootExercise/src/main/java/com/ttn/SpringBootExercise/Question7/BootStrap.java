package com.ttn.SpringBootExercise.Question7;

import com.ttn.SpringBootExercise.Question7.entity.student1;
import com.ttn.SpringBootExercise.Question7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class BootStrap {

    @Autowired
    StudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init() {
        Iterator iterator = studentRepository.findAll().iterator();
        if (!iterator.hasNext()) {
            for (int i = 1; i < 4; i++) {
                student1 student1 = new student1(i, "Student " + i, i + "@gamil.com");
                studentRepository.save(student1);
            }
        }
        System.out.println("Application is inserting values ..");

    }


}
