package com.example.demo.user;

public class Student {
    private Integer studentId;
    private String name;
    private String lastName;
    private Long phoneNumber;
    private String email;
    public Student(Integer studentId ,String name , String lastName , Long phoneNumber,String email) {
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

    public void setPhoneNumber(Long phoneNumber) {
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

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
