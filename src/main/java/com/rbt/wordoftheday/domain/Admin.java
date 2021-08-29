package com.rbt.wordoftheday.domain;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Admin() {
    }

    public Admin(int id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    //Thymeleaf Compatibility
    public String Username() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Thymeleaf Compatibility
    public String Password() {
        return password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
