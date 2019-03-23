package com.ttn.SpringBootExercise;

public class User {
    String UserName;
    Integer Password;

        public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer password) {
        Password = password;
    }
}
