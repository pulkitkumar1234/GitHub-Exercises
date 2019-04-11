package com.ReapWebFinal.ReapWebFinal.entity;

public class SearchEmployeeDTO {
    String UserFirstName;
    String FirstNameValue;

    public SearchEmployeeDTO(String userFirstName, String firstNameValue) {
        UserFirstName = userFirstName;
        FirstNameValue = firstNameValue;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getFirstNameValue() {
        return FirstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        FirstNameValue = firstNameValue;
    }

    public SearchEmployeeDTO(){

    }
}
