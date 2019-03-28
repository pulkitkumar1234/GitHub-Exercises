package com.spring.rest.springrest.versioning;

import com.spring.rest.springrest.entities.Student;

public class StudentV2 {
    private StudentName Name;

    public StudentName getName() {
        return Name;
    }

    public void setName(StudentName name) {
        Name = name;
    }

    public StudentV2(StudentName name) {
        Name = name;
    }


}
