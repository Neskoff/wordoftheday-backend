package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Prize;
import com.rbt.wordoftheday.domain.PrizeList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeListRepository extends CrudRepository<PrizeList, Long> {

    PrizeList findByIsactiveIsTrue();
    List<PrizeList> findAllByIsactiveIsFalse();
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO prizelists(isactive) VALUES(:isActive)")
    int insertPrizeList(@Param("isActive") boolean isActive);

    @Modifying
    @Query(nativeQuery = true, value="UPDATE prizelists SET isactive = false WHERE isactive = true")
    int resetPrizeList();

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE prizelists SET isActive = TRUE WHERE Id = :Id")
    int updateCurrentPrizeList(@Param("Id") int Id);
}
