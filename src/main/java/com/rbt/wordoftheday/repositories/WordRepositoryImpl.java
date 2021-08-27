package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.mappers.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WordRepositoryImpl implements  WordRepository{
    private static final String GET_WOTD = "SELECT * FROM Words Where isWOTD = True";
    private static final String RESET_WOTD = "UPDATE WORDS SET isWOTD = False Where isWOTD = True";
    private static final String INSERT_WOTD = "INSERT INTO Words(Word, isWOTD) VALUES(?,?)";
    private static final String GET_ALL_WORDS = "SELECT * FROM Words WHERE isWOTD = False";
    private static final String UPDATE_WOTD = "UPDATE Words SET isWOTD = True WHERE Word = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Word getWOTD() {
        return this.jdbcTemplate.queryForObject(GET_WOTD, new WordMapper());
    }

    @Override
    public int resetWOTD() {
        return this.jdbcTemplate.update(RESET_WOTD);
    }

    @Override
    public int insertWOTD(Word word) {
        return this.jdbcTemplate.update(INSERT_WOTD, word.Word(), word.isWOTD());
    }

    @Override
    public int updateWOTD(Word word) {
        return this.jdbcTemplate.update(UPDATE_WOTD, word.Word());
    }

    @Override
    public List<Word> getAllWords() {
        return this.jdbcTemplate.query(GET_ALL_WORDS, new WordMapper());
    }
}
