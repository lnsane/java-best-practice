package com.file.steam;


public class User {
    private String id;
    private String userName;

    private Integer age;

    public User(String id) {
        this.id = id;
    }

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
