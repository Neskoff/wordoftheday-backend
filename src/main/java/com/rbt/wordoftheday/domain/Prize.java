package com.rbt.wordoftheday.domain;

import javax.persistence.*;

@Entity
@Table(name = "prizes")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prizeid")
    private int id;
    @Column(name = "prizelistid")
    private int prizelistid;
    @Column(name = "prize")
    private String prize;
    @Column(name = "timesselected")
    private int timesselected;

    public Prize() {
    }

    public Prize(int id, int prizelistid, String prize, int timesselected) {
        this.id = id;
        this.prizelistid = prizelistid;
        this.prize = prize;
        this.timesselected = timesselected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrizelistid() {
        return prizelistid;
    }

    public void setPrizelistid(int prizelistid) {
        this.prizelistid = prizelistid;
    }

    public String Prize() {
        return prize;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getTimesselected() {
        return timesselected;
    }

    public void setTimesselected(int timesselected) {
        this.timesselected = timesselected;
    }
}
