package com.rbt.wordoftheday.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Word{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @NotBlank(message = "You must provide a word")
    private String Word;
    private boolean isWOTD;

    public Word(){};

    public Word(int id, String word, boolean isWOTD) {
        Id = id;
        Word = word;
        this.isWOTD = isWOTD;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String Word() {
        return Word;
    }
    public String getWord() {
        return Word;
    }


    public void setWord(String word) {
        Word = word;
    }


    public void setWOTD(boolean isWOTD) {
        this.isWOTD = isWOTD;
    }

    public boolean isWOTD() {
        return isWOTD;
    }
}
