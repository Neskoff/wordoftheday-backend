package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Campaign;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Campaigns WHERE isactive = true")
    Campaign activeCampaign();

    List<Campaign> findAllByIsactiveIsFalse();


    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Campaigns SET isactive = FALSE WHERE isactive = TRUE ")
    int resetCampaigns();

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE CAMPAIGNS SET isActive = True WHERE Name = :Name ")
    int updateCampaignActive(@Param("Name") String Name);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE CAMPAIGNS SET Name = :Name WHERE isActive = True")
    int updateCampaignName(@Param("Name") String Name);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO CAMPAIGNS(Name, isActive) VALUES(:Name, True)")
    int insertNewCampaign(@Param("Name") String Name);
}
