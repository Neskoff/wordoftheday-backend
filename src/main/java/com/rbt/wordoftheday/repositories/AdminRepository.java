package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    int countByUsernameAndPassword(String Username, String Password);
}
