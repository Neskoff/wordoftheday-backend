package com.rbt.wordoftheday.repositories;

public interface AdminRepository {

    boolean adminExists(String Username, String Password);
}
