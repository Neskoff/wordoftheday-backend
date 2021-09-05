package com.rbt.wordoftheday.services.campaignService;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.repositories.CampaignRepository;
import com.rbt.wordoftheday.services.campaignService.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public Campaign getCurrentCampaign() {
        return this.campaignRepository.activeCampaign();
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return this.campaignRepository.findAllByIsactiveIsFalse();
    }

    @Override
    public boolean resetCampaigns() {
        return this.campaignRepository.resetCampaigns() != 0;
    }

    @Override
    public boolean updateCampaign(Campaign campaign) {
        return this.campaignRepository.updateCampaignActive(campaign.getName()) != 0;
    }

    @Override
    public boolean updateName(Campaign campaign) {
        return this.campaignRepository.updateCampaignName(campaign.getName()) != 0;
    }

    @Override
    public boolean insertNewCampaign(Campaign campaign) {
        return this.campaignRepository.insertNewCampaign(campaign.getName()) != 0;
    }
}
