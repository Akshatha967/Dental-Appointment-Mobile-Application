package com.example.mad_project1;

public class d_DataModelProfile {
    String name,specialization,email,gender,location;
    long phone;

    public d_DataModelProfile(String name, String specialization, String email, long phone, String gender, String location) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
