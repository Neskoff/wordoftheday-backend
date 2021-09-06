package com.rbt.wordoftheday.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @Column(name ="campaignid")
    private int CampaignId;
    @Column(name = "nousers")
    private int NoUsers;
    @Column(name = "nocorrect")
    private int NoCorrect;
    @Column(name = "nofail")
    private int NoFail;

    public Report() {
    }

    public Report(int campaignId, int noUsers, int noCorrect, int noFail) {
        CampaignId = campaignId;
        NoUsers = noUsers;
        NoCorrect = noCorrect;
        NoFail = noFail;
    }

    public int getCampaignId() {
        return CampaignId;
    }

    public int CampaignId() {
        return CampaignId;
    }

    public void setCampaignId(int campaignId) {
        CampaignId = campaignId;
    }

    public int getNoUsers() {
        return NoUsers;
    }

    public int NoUsers() {
        return NoUsers;
    }

    public void setNoUsers(int noUsers) {
        NoUsers = noUsers;
    }

    public int getNoCorrect() {
        return NoCorrect;
    }

    public int NoCorrect() {
        return NoCorrect;
    }

    public void setNoCorrect(int noCorrect) {
        NoCorrect = noCorrect;
    }

    public int getNoFail() {
        return NoFail;
    }

    public int NoFail() {
        return NoFail;
    }

    public void setNoFail(int noFail) {
        NoFail = noFail;
    }
}
