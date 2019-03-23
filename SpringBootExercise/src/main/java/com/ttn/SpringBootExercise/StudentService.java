package com.ttn.SpringBootExercise;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private List<Student> Students=Arrays.asList(
                new Student(001,"Pulkit","MCA",24)
                ,new Student(002,"Shubham","MCA",26)
                ,new Student(003,"Raju","MBA",25));


    public List<Student> getAllStudent(){
        return Students;
    }

    public Student getStudent(Integer id){
        return Students.stream().filter(s->s.getId().equals(id)).findFirst().get();
    }
}
