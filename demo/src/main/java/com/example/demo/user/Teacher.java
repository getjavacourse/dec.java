package com.example.demo.user;

public class Teacher {
        private Integer id;
        private String name;
        private String lastName;
        private Long phoneNumber;
        private String email;
        public Teacher(Integer id ,String name , String lastName , long phoneNumber,String email) {
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

        public void setPhoneNumber(Long phoneNumber) {
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

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }
    }


