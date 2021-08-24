package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
public class AdminResource {
    @Autowired
    private AdminService adminService;
    @GetMapping
    public ResponseEntity<Boolean> adminExists(String Username, String Password)
    {
        return ResponseEntity.ok(this.adminService.adminExists(Username, Password));
    }
}
