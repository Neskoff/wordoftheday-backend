package com.rbt.wordoftheday.domain;

import javax.persistence.*;

@Entity
@Table(name = "prizelists")
public class PrizeList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "isactive")
    private boolean isactive;

    public PrizeList() {
    }

    public PrizeList(int id, boolean isactive) {
        this.id = id;
        this.isactive = isactive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}
