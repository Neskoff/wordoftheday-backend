package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.domain.Word;

import java.util.List;

public interface WordService {
    Word getWOTD();
    boolean resetWOTD();
    boolean insertWOTD(Word word);
    boolean updateWOTD(Word word);
    List<Word> getAllWords();
}
