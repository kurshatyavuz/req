package com.reqres.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String email;
    private String password;
    private int id;
    private String token;


    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonIgnore
    public int getId() {
        return id;
    }
    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }
    @JsonIgnore
    public String getToken() {
        return token;
    }
    @JsonProperty
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
