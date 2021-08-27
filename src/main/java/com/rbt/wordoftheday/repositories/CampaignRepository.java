package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Campaign;

import java.util.List;

public interface CampaignRepository {

    List<Campaign> getAllCampaigns();
    int resetAllCampaigns();
    int updateCampaign(Campaign campaign);
    int updateName(Campaign campaign);
}
