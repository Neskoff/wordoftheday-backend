package com.rbt.wordoftheday.domain;

import javax.persistence.*;

@Entity
@Table(name = "uses")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Username;
    private String Email;
    private String BirthDate;

    public User(){};

    public User(int id, String username, String email, String birthDate) {
        Id = id;
        Username = username;
        Email = email;
        BirthDate = birthDate;
    }

    public int getId() {
        return Id;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

}
