package com.spring.exercise.controller;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {

    @Size(max = 10, min = 2)
    @Pattern(regexp ="[^0-9]*")
    String firstName;
    String lastName;
    Integer password;

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
