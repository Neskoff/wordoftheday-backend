package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.domain.Report;
import com.rbt.wordoftheday.services.campaignService.CampaignService;
import com.rbt.wordoftheday.services.reportService.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CampaignController {
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private ReportService reportService;

    @PostMapping("/home/updateCampaign")
    public String updateCampaign(@Valid Campaign campaign) {
        this.campaignService.resetCampaigns();
        campaign.setActive(true);
        this.campaignService.updateCampaign(campaign);
        RootController.campaignsRedirect = true;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = false;
        return "redirect:/home";
    }

    @PostMapping("/home/updateName")
    public String updateCampaignName(@Valid Campaign campaign) {
        this.campaignService.updateName(campaign);
        RootController.campaignsRedirect = true;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = false;
        return "redirect:/home";
    }

    @PostMapping("/home/insertCampaign")
    public String insertNewCampaign(@Valid Campaign campaign) {
        this.campaignService.resetCampaigns();
        this.campaignService.insertNewCampaign(new Campaign(0, campaign.getName(), true));
        this.reportService.insertCampaignReport(new Report(this.campaignService.getCurrentCampaign().getId(), 0, 0, 0));
        RootController.campaignsRedirect = true;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = false;
        return "redirect:/home";

    }
}
