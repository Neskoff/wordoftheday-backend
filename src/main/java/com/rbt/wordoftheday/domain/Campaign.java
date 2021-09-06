package com.rbt.wordoftheday.domain;

import javax.persistence.*;

@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String Name;
    @Column(name = "isactive")
    private Boolean isactive;

    public Campaign() {
    }

    public Campaign(int id, String name, Boolean isactive) {
        this.id = id;
        Name = name;
        this.isactive = isactive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public String Name() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getActive() {
        return isactive;
    }

    public void setActive(Boolean active) {
        isactive = active;
    }
}
