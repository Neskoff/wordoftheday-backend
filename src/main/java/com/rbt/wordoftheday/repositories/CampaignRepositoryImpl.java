package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.mappers.CampaignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CampaignRepositoryImpl implements CampaignRepository{
    private static final String GET_CAMPAIGNS = "SELECT * FROM Campaigns";
    private static final String RESET_CAMPAIGNS = "UPDATE CAMPAIGNS SET isActive = False WHERE isActive = True";
    private static final String UPDATE_CAMPAIGN = "UPDATE CAMPAIGNS SET isActive = True WHERE Name = ?";
    private static final String UPDATE_NAME = "UPDATE CAMPAIGNS SET Name = ? WHERE isActive = True";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Campaign> getAllCampaigns() {
        return this.jdbcTemplate.query(GET_CAMPAIGNS, new CampaignMapper());
    }

    @Override
    public int resetAllCampaigns() {
        return this.jdbcTemplate.update(RESET_CAMPAIGNS);
    }

    @Override
    public int updateCampaign(Campaign campaign) {
        return this.jdbcTemplate.update(UPDATE_CAMPAIGN, campaign.getName());
    }

    @Override
    public int updateName(Campaign campaign) {
        return this.jdbcTemplate.update(UPDATE_NAME, campaign.getName());
    }
}
