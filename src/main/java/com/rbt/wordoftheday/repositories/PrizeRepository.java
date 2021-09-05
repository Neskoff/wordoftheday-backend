package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Prize;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrizeRepository extends CrudRepository<Prize, Long> {
    List<Prize> findAllByPrizelistid(int prizeListId);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO prizes(prizelistid, prize, timesselected) VALUES(" +
            ":prizeList, :prize, :timesSelected)")
    int insertPrize(@Param("prizeList") int prizeList, @Param("prize") String prize, @Param("timesSelected")
            int timesSelected);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE prizes set timesselected = timesselected+1 where prizeid = :Id")
    int updateTimesSelected(@Param("Id") int Id);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE prizes SET prize = :Prize WHERE id = :Id")
    int updatePrizeName(@Param("Prize") String Prize, @Param("Id") int Id);

    @Modifying
    int deleteById(int Id);

}
