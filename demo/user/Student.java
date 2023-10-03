package com.example.demo.user;

public class Student {
    public Integer studentId;
    public String name;
    public String lastName;

    public Integer phoneNumber;
    public String email;
    public Student(Integer studentId ,String name , String lastName , Integer phoneNumber,String email) {
        this.studentId =studentId;
        this.name=name;
        this.lastName=lastName;
        this.phoneNumber = phoneNumber;
        this.email=email;

    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
