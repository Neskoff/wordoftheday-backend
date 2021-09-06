package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO Users (Username, Email, Birthdate) VALUES('TestUser', :Email, :BirthDate)")
    int insertUser(@Param("Email") String Email, @Param("BirthDate") String BirthDate);
}
