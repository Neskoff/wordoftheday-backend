package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.*;
import com.rbt.wordoftheday.services.campaignService.CampaignService;
import com.rbt.wordoftheday.services.prizeListService.PrizeListService;
import com.rbt.wordoftheday.services.prizeService.PrizeService;
import com.rbt.wordoftheday.services.reportService.ReportService;
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
    @Autowired
    private PrizeListService prizeListService;
    @Autowired
    private PrizeService prizeService;

    public static String currentAdmin;
    public static Word currentWordOfTheDay;
    public static String resultSet = "";
    public static boolean wordsRedirect = true;
    public static boolean campaignsRedirect;
    public static boolean prizesRedirect;
    public static int currentListId;

    private void generateModelAttributes(Model model) {
        currentWordOfTheDay = this.wordService.findByWordOfTheDayIsTrue();
        List<Word> allWords = this.wordService.allWords();
        Campaign currentCampaign = this.campaignService.getCurrentCampaign();
        List<Campaign> allCampaigns = this.campaignService.getAllCampaigns();
        Report currentReport = this.reportService.getCampaignReport(currentCampaign.getId());
        PrizeList currentPrizeList = this.prizeListService.getCurrentPrizeList();
        currentListId = currentPrizeList.getId();
        List<PrizeList> allPrizeLists = this.prizeListService.getInactivePrizeLists();
        List<Prize> currentPrizes = this.prizeService.findAllByPrizeListId(currentPrizeList.getId());
        this.feedback();
        model.addAttribute("name", currentAdmin);
        model.addAttribute("WOTD", currentWordOfTheDay);
        model.addAttribute("allWords", allWords);
        model.addAttribute("currentCampaign", currentCampaign);
        model.addAttribute("allCampaigns", allCampaigns);
        model.addAttribute("currentReport", currentReport);
        model.addAttribute("campaignsRedirect", campaignsRedirect);
        model.addAttribute("wordsRedirect", wordsRedirect);
        model.addAttribute("prizesRedirect", prizesRedirect);
        model.addAttribute("newCampaign",new Campaign());
        model.addAttribute("currentPrizeList", currentPrizeList);
        model.addAttribute("allPrizeLists", allPrizeLists);
        model.addAttribute("currentPrizes", currentPrizes);
        model.addAttribute("newPrizes", new Prize());
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
