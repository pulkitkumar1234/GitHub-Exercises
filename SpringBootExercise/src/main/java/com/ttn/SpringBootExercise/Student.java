package com.ttn.SpringBootExercise;

public class Student {
    Integer Id;
    String StudentName;
    String Course;
    Integer Age;

    public Student() {

    }


    public Student(Integer id, String studentName, String course, Integer age) {
        super();
        Id = id;
        StudentName = studentName;
        Course = course;
        Age = age;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
