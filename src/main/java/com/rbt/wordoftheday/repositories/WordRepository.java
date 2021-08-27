package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Word;

import java.util.List;


public interface WordRepository {

    Word getWOTD();
    int resetWOTD();
    int insertWOTD(Word word);
    int updateWOTD(Word word);
    List<Word> getAllWords();
}
