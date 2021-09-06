package com.rbt.wordoftheday.services.userService;

import com.rbt.wordoftheday.domain.User;
import com.rbt.wordoftheday.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean sendMessage(String email, String prize) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rtbword@gmail.com");
        message.setTo(email);
        message.setSubject("Congratulations!");
        message.setText("Congratulations " + email + " you won " + prize);
        emailSender.send(message);
        return true;

    }

    @Override
    public boolean insertUser(User user) {
        return this.userRepository.insertUser(user.getEmail(), user.getBirthDate()) != 0;
    }
}
