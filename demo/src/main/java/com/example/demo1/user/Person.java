package com.example.demo1.user;

public class Person {
        public Integer id;
        public String name;
        public String lastName;

        public Integer phoneNumber;
        public String email;
        public Person(Integer id ,String name , String lastName , Integer phoneNumber,String email) {
            this.id =id;
            this.name=name;
            this.lastName=lastName;
            this.phoneNumber = phoneNumber;
            this.email=email;

        }

        public void setId(Integer id) {
            this.id = id;
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

        public Integer getId() {
            return id;
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


