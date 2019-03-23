package com.ttn.SpringBootExercise.Question7.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class student1 {


    @Id
    private int id;
    private  String name;
    private String email;

    student1(){

    }


    public student1(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}