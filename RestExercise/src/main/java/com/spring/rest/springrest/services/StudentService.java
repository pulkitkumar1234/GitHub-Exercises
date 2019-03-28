package com.spring.rest.springrest.services;

import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public Student getStudent(Integer Id){
        return studentRepository.findById(Id).orElse(null);
    }
    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
}
