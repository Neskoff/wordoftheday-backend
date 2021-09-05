package com.rbt.wordoftheday.services.userService;

import com.rbt.wordoftheday.domain.User;

public interface UserService {
    boolean sendMessage(String email, String prize);

    boolean insertUser(User user);
}
