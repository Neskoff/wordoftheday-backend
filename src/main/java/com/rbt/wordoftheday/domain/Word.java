package com.rbt.wordoftheday.domain;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "word")
    private String word;
    @Column(name = "isWordOfTheDay")
    private boolean wordOfTheDay;

    public Word() {
    }

    public Word(int id, String word, boolean wordOfTheDay) {
        this.id = id;
        this.word = word;
        this.wordOfTheDay = wordOfTheDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Thymeleaf Compatibility
    public String Word() {
        return word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setWordOfTheDay(boolean wordOfTheDay) {
        this.wordOfTheDay = wordOfTheDay;
    }

    public boolean isWordOfTheDay() {
        return wordOfTheDay;
    }
}
