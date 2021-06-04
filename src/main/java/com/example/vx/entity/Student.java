package com.example.vx.entity;

public class Student {
    String phone;
    String password;
    String name;
    String id;
    String major;
    String mail;
    String time_class;
    String teacher;

    public String getMail() {
        return mail;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getTime_class() {
        return time_class;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTime_class(String time_class) {
        this.time_class = time_class;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
