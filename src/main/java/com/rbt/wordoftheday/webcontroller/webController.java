package com.rbt.wordoftheday.webcontroller;

import com.rbt.wordoftheday.domain.Admin;
import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.services.AdminService;
import com.rbt.wordoftheday.services.CampaignService;
import com.rbt.wordoftheday.services.ReportService;
import com.rbt.wordoftheday.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller("/")
public class webController {
@Autowired
private AdminService adminService;
@Autowired
private WordService wordService;
@Autowired
private CampaignService campaignService;
@Autowired
private ReportService reportService;
private String currentAdmin;
private Word currentWOTD;
private Campaign currentCampaign;
private boolean resultSet = false;

    @ModelAttribute("insertSuccess")
    public boolean feedback()
    {
        return this.resultSet;
    }
    @GetMapping("/")
    public String getLoginPage(Model model){
        model.addAttribute("admin", new Admin());
        return "login";
    }
    @GetMapping("/home")
    public String getHomePage(Model model){
        this.currentWOTD = this.wordService.getWOTD();
        model.addAttribute("name",currentAdmin);
        if (currentAdmin == null)
            return "redirect:/";
        else {
            this.currentCampaign = this.campaignService.getCurrentCampaign();
            model.addAttribute("WOTD", currentWOTD);
            model.addAttribute("allwords", this.wordService.getAllWords());
            model.addAttribute("currentcampaign",currentCampaign);
            model.addAttribute("allcampaigns", this.campaignService.getAllCampaigns());
            model.addAttribute("currentReport",this.reportService.getCampaignReport
                    (this.currentCampaign.getId()));
            return "index";
        }
    }
    @PostMapping("/loginAction")
    public String logInAdmin( @Valid Admin admin, BindingResult result, Model model){
        if (result.hasErrors()) {
            admin.setId(0);
            return "login";
        }
        else if (this.adminService.adminExists(admin.getUsername(), admin.getPassword())) {
            currentAdmin = admin.getUsername();
            return "redirect:/home";
        }
        else
            return "login";

    }
    @PostMapping("/home/insertWotd")
    public String insertWOTD(@Valid Word word, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            word.setId(0);

        }
        else if(word.Word().length() > 3 && (!word.Word().equals( currentWOTD.Word())))
        {
            this.wordService.resetWOTD();
            word.setWOTD(true);
            this.resultSet = this.wordService.insertWOTD(word);
            this.feedback();
        }
        return "redirect:/home";
    }
    @PostMapping("/home/insertList")
    public String insertList(@Valid Word word, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            word.setId(0);

        }
        else if(!word.Word().equals( currentWOTD.Word()) && (word.Word().length() > 3))
        {
            this.wordService.resetWOTD();
            this.resultSet = this.wordService.updateWOTD(word);
            this.feedback();
        }
        return "redirect:/home";
    }
    @PostMapping("/home/updateCampaign")
    public String updateCampaign(@Valid Campaign campaign, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            campaign.setId(0);

        }
        else
        {
            this.campaignService.resetCampaigns();
            campaign.setActive(true);
            this.campaignService.updateCampaign(campaign);
        }
        return "redirect:/home";
    }
    @PostMapping("/home/updateName")
    public String insertWOTD(@Valid Campaign campaign, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            campaign.setId(0);

        }
        else
        {
            this.campaignService.updateName(campaign);
        }
        return "redirect:/home";
    }


}
