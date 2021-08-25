package com.rbt.wordoftheday.mappers;

import com.rbt.wordoftheday.domain.Word;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WordMapper implements RowMapper<Word> {

    @Override
    public Word mapRow(ResultSet resultSet, int i) throws SQLException {
        Word word = new Word();
        word.setId(resultSet.getInt("Id"));
        word.setWord(resultSet.getString("Word"));
        word.setWOTD(resultSet.getBoolean("isWOTD"));
        return word;
    }
}
