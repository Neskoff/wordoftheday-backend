package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.mappers.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WordRepositoryImpl implements  WordRepository{
    private static final String GET_WOTD = "SELECT * FROM Words Where isWOTD = True";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Word getWOTD() {
        return this.jdbcTemplate.queryForObject(GET_WOTD, new WordMapper());
    }
}
