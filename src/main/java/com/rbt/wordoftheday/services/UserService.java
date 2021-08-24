package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.domain.User;

public interface UserService {

    User getUserByUsername(String username);
    boolean insertUser(User user);
}
