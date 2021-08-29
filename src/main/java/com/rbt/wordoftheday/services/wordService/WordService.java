package com.rbt.wordoftheday.services.wordService;

import com.rbt.wordoftheday.domain.Word;

import java.util.List;


public interface WordService {
    Word findByWordOfTheDayIsTrue();

    List<Word> allWords();

    boolean insertWordOfTheDay(Word word);

    boolean resetWordOfTheDay();

    boolean updateWordOfTheDay(String word);
}
