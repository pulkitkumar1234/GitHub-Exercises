package com.spring.rest.springrest.versioning;

public class StudentV1 {
    private  String Name;

    public StudentV1(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
