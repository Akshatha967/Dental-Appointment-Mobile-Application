package com.example.mad_project1;

public class DataModel {
    String name,specializaion,email;

    public DataModel(String name, String specializaion, String email) {
        this.name = name;
        this.specializaion = specializaion;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecializaion() {
        return specializaion;
    }

    public void setSpecializaion(String specializaion) {
        this.specializaion = specializaion;
    }

    public String getEmail() {
        return email;
    }

    public void setLocation(String location) {
        this.email = email;
    }
}
