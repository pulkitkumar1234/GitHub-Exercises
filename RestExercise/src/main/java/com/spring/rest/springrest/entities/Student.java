package com.spring.rest.springrest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties(value = {"age","city","id"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;

    @Size(max = 10, min = 2,message = "Name Length Must be between 2 and 10")
    String Name;
    String Standard;
    Integer Age;
    Integer Percentage;
    String City;
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String standard) {
        Standard = standard;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getPercentage() {
        return Percentage;
    }

    public void setPercentage(Integer percentage) {
        Percentage = percentage;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Standard='" + Standard + '\'' +
                ", Age=" + Age +
                ", Percentage=" + Percentage +
                ", City='" + City + '\'' +
                '}';
    }
}
