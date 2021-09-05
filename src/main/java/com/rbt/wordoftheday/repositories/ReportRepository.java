package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Report;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Reports WHERE CampaignId = :CampaignId")
    Report getCampaignReport(@Param("CampaignId") int CampaignId);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO REPORTS (campaignid, nousers, nocorrect, nofail) " +
            "VALUES(:campaignId, :noUsers, :noCorrect, :noFail)")
    int insertCampaignReport(@Param("campaignId") int campaignId, @Param("noUsers") int noUsers, @Param("noCorrect")
            int noCorrect, @Param("noFail") int noFail);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Reports SET nousers = :noUsers, nocorrect = :noCorrect, nofail = :noFail WHERE CampaignId = :campaignId")
    int updateCampaignReport(@Param("campaignId") int campaignId, @Param("noUsers") int noUsers, @Param("noCorrect")
            int noCorrect, @Param("noFail") int noFail);
}
