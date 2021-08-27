package com.rbt.wordoftheday.services;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;
    @Override
    public Campaign getCurrentCampaign() {
        return this.campaignRepository.getAllCampaigns().stream().filter(x -> x.getActive() == true)
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return this.campaignRepository.getAllCampaigns().stream().filter(x -> x.getActive() == false)
                .collect(Collectors.toList());
    }

    @Override
    public boolean resetCampaigns() {
        int resultSet = this.campaignRepository.resetAllCampaigns();
        if (resultSet !=0)
            return true;
        return false;
    }

    @Override
    public boolean updateCampaign(Campaign campaign) {
        int resultSet = this.campaignRepository.updateCampaign(campaign);
        if (resultSet !=0)
            return true;
        return false;
    }

    @Override
    public boolean updateName(Campaign campaign) {
        int resultSet = this.campaignRepository.updateName(campaign);
        if (resultSet !=0)
            return true;
        return false;
    }
}
