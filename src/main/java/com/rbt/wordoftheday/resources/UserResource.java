package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.domain.User;
import com.rbt.wordoftheday.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/email")
    public ResponseEntity<Boolean> sendEmail(String email, String prize) {
        return ResponseEntity.ok(this.userService.sendMessage(email, prize));
    }

    @PostMapping("/")
    public ResponseEntity<Boolean> insertUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.insertUser(user));
    }

}
