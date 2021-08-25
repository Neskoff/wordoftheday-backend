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
    public int Id;
    @NotBlank(message = "You must provide a word")
    public String Word;
    public boolean isWOTD;

    public Word(){};

    public Word(int id, String word, boolean isWOTD) {
        Id = id;
        Word = word;
        this.isWOTD = isWOTD;
    }

    public void setId(int id) {
        Id = id;
    }


    public void setWord(String word) {
        Word = word;
    }


    public void setWOTD(boolean WOTD) {
        isWOTD = WOTD;
    }
}
