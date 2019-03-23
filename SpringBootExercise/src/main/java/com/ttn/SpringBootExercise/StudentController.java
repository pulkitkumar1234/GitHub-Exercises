package com.ttn.SpringBootExercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @RequestMapping("student/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudent(id);
    }
}
