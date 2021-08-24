package com.rbt.wordoftheday.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    private static final String ADMIN_EXISTS = "SELECT COUNT(Id) FROM Admins WHERE Username = ? AND Password = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean adminExists(String Username, String Password) {
        return jdbcTemplate.queryForObject(ADMIN_EXISTS, Integer.class, Username, Password) > 0;
    }
}
