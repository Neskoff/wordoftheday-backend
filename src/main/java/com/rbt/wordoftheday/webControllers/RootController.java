package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.domain.Report;
import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.services.*;
import com.rbt.wordoftheday.services.wordService.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class RootController {
    @Autowired
    private WordService wordService;
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private ReportService reportService;
    public static String currentAdmin;
    public static Word currentWordOfTheDay;
    public static String resultSet = "";
    public static boolean wordsRedirect = true;
    public static boolean campaignsRedirect;
    public static boolean prizesRedirect;

    private void generateModelAttributes(Model model) {
        currentWordOfTheDay = this.wordService.findByWordOfTheDayIsTrue();
        List<Word> allWords = this.wordService.allWords();
        Campaign currentCampaign = this.campaignService.getCurrentCampaign();
        List<Campaign> allCampaigns = this.campaignService.getAllCampaigns();
        Report currentReport = this.reportService.getCampaignReport(currentCampaign.getId());
        this.feedback();
        model.addAttribute("name", currentAdmin);
        model.addAttribute("WOTD", currentWordOfTheDay);
        model.addAttribute("allWords", allWords);
        model.addAttribute("currentCampaign", currentCampaign);
        model.addAttribute("allCampaigns", allCampaigns);
        model.addAttribute("currentReport", currentReport);
        model.addAttribute("campaignsRedirect", campaignsRedirect);
        model.addAttribute("wordsRedirect", wordsRedirect);
    }

    @ModelAttribute("resultSet")
    public String feedback() {
        return resultSet;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        if (currentAdmin == null) {
            return "redirect:/";
        } else {
            generateModelAttributes(model);
            return "index";
        }
    }
}
