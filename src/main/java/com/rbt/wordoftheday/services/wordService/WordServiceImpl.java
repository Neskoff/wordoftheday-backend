package com.rbt.wordoftheday.services.wordService;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.repositories.WordRepository;
import com.rbt.wordoftheday.services.wordService.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService {
    @Autowired
    WordRepository wordRepository;

    @Override
    public Word findByWordOfTheDayIsTrue() {
        return this.wordRepository.findByWordOfTheDayIsTrue();
    }

    @Override
    public List<Word> allWords() {
        List<Word> resultSet = new ArrayList<Word>();
        this.wordRepository.findAll().forEach(resultSet::add);
        return resultSet;
    }

    @Override
    public boolean insertWordOfTheDay(Word word) {
        return this.wordRepository.insertWordOfTheDay(word.getWord(), word.isWordOfTheDay()) == 1;
    }

    @Override
    public boolean resetWordOfTheDay() {
        return this.wordRepository.resetWordOfTheDay() != 0;
    }

    @Override
    public boolean updateWordOfTheDay(String word) {
        return this.wordRepository.updateWordOfTheDay(word) != 0;
    }


}
