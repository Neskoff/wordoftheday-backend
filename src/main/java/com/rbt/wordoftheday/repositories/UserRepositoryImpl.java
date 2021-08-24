package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.rbt.wordoftheday.mappers.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private static final String GET_USER_BY_ID = "SELECT * FROM Users WHERE Username = ?";
    private static final String INSERT_USER = "INSERT INTO USERS(Username,Email,BirthDate) VALUES (?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User getUserByUsername(String username) {

        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserMapper(), username);
    }

    @Override
    public int insertUser(User user) {
        return jdbcTemplate.update(INSERT_USER, user.getUsername(), user.getEmail(), user.getBirthDate());
    }
}
