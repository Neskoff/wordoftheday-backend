package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WordServiceImpl implements WordService{
    @Autowired
    private WordRepository wordRepository;
    @Override
    public Word getWOTD() {
        return this.wordRepository.getWOTD();
    }

    @Override
    public boolean resetWOTD() {
        int resultSet =  this.wordRepository.resetWOTD();
        if (resultSet !=0)
            return true;
        return false;
    }

    @Override
    public boolean insertWOTD(Word word) {
        int resultSet = this.wordRepository.insertWOTD(word);
        if (resultSet !=0)
            return true;
        return false;
    }

    @Override
    public boolean updateWOTD(Word word) {
        int resultSet = this.wordRepository.updateWOTD(word);
        if (resultSet !=0)
            return true;
        return false;
    }

    @Override
    public List<Word> getAllWords() {
        return this.wordRepository.getAllWords();
    }
}
