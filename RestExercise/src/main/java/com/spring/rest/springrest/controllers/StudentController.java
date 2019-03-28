package com.spring.rest.springrest.controllers;

import com.spring.rest.springrest.entities.Post;
import com.spring.rest.springrest.entities.Student;
import com.spring.rest.springrest.versioning.StudentName;
import com.spring.rest.springrest.versioning.StudentV1;
import com.spring.rest.springrest.versioning.StudentV2;
import com.spring.rest.springrest.exceptions.StudentNotFoundException;
import com.spring.rest.springrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    MessageSource messageSource;

   /* @GetMapping("/")
    String Hello(){
        return "Hellow World";
    }*/

    @GetMapping("/")
    String helloWorld(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
          return messageSource.getMessage("good.morning.message",null,locale);
    }

    @GetMapping("/student")
    List< Student> getStudentById(){
       return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable Integer id){
        Student student=studentService.getStudent(id);
        if(student==null){
            throw new StudentNotFoundException("Student Not Found");
        }
        return student;
    }

    @PostMapping("/savestudent")
    void saveStudent(Student student){
        studentService.saveStudent(student);
    }

    @PostMapping("/deletestudent")
    void deleteStudent(Student student){
        studentService.deleteStudent(student);
    }

    @GetMapping("/post")
    public String getPost(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @GetMapping("/postObject")
    public Post getPostObject(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<Post> response = restTemplate.getForEntity(url,Post.class);
        System.out.println(response.getStatusCode().toString());
        System.out.println(response.getHeaders().toString());
        return response.getBody();
    }

    @GetMapping("/postList")
    public List<Post> getPostList(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List<Post>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>(){});
        return response.getBody();
    }

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(){
        String url="https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(10000,10000,"title1","description1"),httpHeaders);
        Post post=restTemplate.postForObject(url,request,Post.class);
        System.out.println(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost(){
        String url="https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(1,100,"title1","description1"),httpHeaders);
        return restTemplate.exchange(url,HttpMethod.PUT,request,Post.class);
    }

    @DeleteMapping("/deletePost")
    public void deletePost(){
        String url="https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(httpHeaders);
        restTemplate.exchange(url,HttpMethod.DELETE,request,Post.class);
    }

}
