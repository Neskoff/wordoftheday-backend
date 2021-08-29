package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.services.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @PostMapping("/home/updateCampaign")
    public String updateCampaign(@Valid Campaign campaign, BindingResult result, Model model) {
        if (result.hasErrors()) {
            campaign.setId(0);

        } else {
            this.campaignService.resetCampaigns();
            campaign.setActive(true);
            this.campaignService.updateCampaign(campaign);
            RootController.campaignsRedirect = true;
            RootController.wordsRedirect = false;
        }
        return "redirect:/home";
    }

    @PostMapping("/home/updateName")
    public String insertWOTD(@Valid Campaign campaign, BindingResult result, Model model) {
        if (result.hasErrors()) {

        } else {
            this.campaignService.updateName(campaign);
        }
        return "redirect:/home";
    }
}
