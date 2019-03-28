package com.thymeleaf.exercise.thymeleafexercise;

public class user {
    String Name;
    Boolean admin;
    Boolean  Super_admin;

    public Boolean getSuper_admin() {
        return Super_admin;
    }

    public void setSuper_admin(Boolean super_admin) {
        Super_admin = super_admin;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
