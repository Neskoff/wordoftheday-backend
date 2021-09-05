package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.PrizeList;
import com.rbt.wordoftheday.services.prizeListService.PrizeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PrizeListController {
    @Autowired
    private PrizeListService prizeListService;

    @PostMapping("home/currentPrizeList")
    public String currentPrizeList(@Valid PrizeList prizeList)
    {
        this.prizeListService.resetPrizeList();
        this.prizeListService.updateCurrentPrizeList(prizeList.getId());
        RootController.campaignsRedirect = false;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = true;
        return "redirect:/home";
    }

    @PostMapping("home/newPrizeList")
    public String newPrizeList()
    {
        this.prizeListService.resetPrizeList();
        this.prizeListService.insertPrizeList(new PrizeList(0,true));
        RootController.campaignsRedirect = false;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = true;
        return "redirect:/home";
    }
}
