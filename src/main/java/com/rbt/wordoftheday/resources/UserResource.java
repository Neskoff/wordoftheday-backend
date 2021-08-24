package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.domain.User;
import com.rbt.wordoftheday.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username)
    {
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }
    @PostMapping("/InsertUser")
    public boolean insertUser(@RequestBody User user)
    {
        return this.userService.insertUser(user);
    }
}
