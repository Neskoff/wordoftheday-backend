package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.User;

public interface UserRepository {

    User getUserByUsername(String username);
    int insertUser(User user);
}
