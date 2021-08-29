package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Word;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    Word findByWordOfTheDayIsTrue();

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO Words(Word,is_Word_Of_The_Day) VALUES (:Word,:isWordOfTheDay)")
    int insertWordOfTheDay(@Param("Word") String Word, @Param("isWordOfTheDay") boolean isWordOfTheDay);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Words SET is_Word_Of_The_Day = False Where is_Word_Of_The_Day = True")
    int resetWordOfTheDay();

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Words SET is_Word_Of_The_Day = True Where Word = :Word")
    int updateWordOfTheDay(@Param("Word") String Word);
}
