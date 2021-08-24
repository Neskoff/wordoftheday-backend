package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.domain.User;
import com.rbt.wordoftheday.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean insertUser(User user) {
        int resultSet = this.userRepository.insertUser(user);
        if(resultSet !=0)
            return true;
        return false;
    }
}
