package com.ttn.SpringBootExercise.Question7;

import com.ttn.SpringBootExercise.Question7.entity.student1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Student1Controller {

    Student1Service student1Service;


    @RequestMapping("/showDataBaseJPA")
    String show(){
        return "question7.html";
    }

    @RequestMapping("/getContent")
   public List<student1> getStudent(){

        return student1Service.getStudent();
    }
}

