package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public boolean adminExists(String Username, String Password) {
        return this.adminRepository.adminExists(Username, Password);
    }
}
