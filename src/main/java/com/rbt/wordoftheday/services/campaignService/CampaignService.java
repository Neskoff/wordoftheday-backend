package com.rbt.wordoftheday.services.campaignService;

import com.rbt.wordoftheday.domain.Campaign;

import java.util.List;

public interface CampaignService {
    Campaign getCurrentCampaign();
    List<Campaign> getAllCampaigns();
    boolean resetCampaigns();
    boolean updateCampaign(Campaign campaign);
    boolean updateName(Campaign campaign);
    boolean insertNewCampaign(Campaign campaign);
}
