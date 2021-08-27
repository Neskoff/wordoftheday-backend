package com.rbt.wordoftheday.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;
    private Boolean isActive;

    public Campaign(){};

    public Campaign(int id, String name, Boolean isActive) {
        Id = id;
        Name = name;
        this.isActive = isActive;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
