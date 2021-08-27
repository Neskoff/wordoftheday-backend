package com.rbt.wordoftheday.mappers;

import com.rbt.wordoftheday.domain.Campaign;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CampaignMapper implements RowMapper<Campaign> {
    @Override
    public Campaign mapRow(ResultSet resultSet, int i) throws SQLException {
        Campaign campaign = new Campaign();
        campaign.setId(resultSet.getInt("Id"));
        campaign.setName(resultSet.getString("Name"));
        campaign.setActive(resultSet.getBoolean("isActive"));
        return campaign;
    }
}