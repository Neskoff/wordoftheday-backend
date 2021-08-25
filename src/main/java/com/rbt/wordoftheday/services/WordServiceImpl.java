package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WordServiceImpl implements WordService{
    @Autowired
    private WordRepository wordRepository;
    @Override
    public Word getWOTD() {
        return this.wordRepository.getWOTD();
    }
}
