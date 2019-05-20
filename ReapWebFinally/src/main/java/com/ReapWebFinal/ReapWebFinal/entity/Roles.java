package com.ReapWebFinal.ReapWebFinal.entity;


public enum Roles {

    ADMIN("ADMIN"),
    USER("USER"),
    PRACTICE_HEAD("Practice Head"),
    SUPERVISOR("SUPERVISOR");

    String value;
    Roles(String value) {
        this.value = value;
    }
    public String getValue(){
        return value;
    }

}