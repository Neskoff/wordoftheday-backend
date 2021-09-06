package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.Prize;
import com.rbt.wordoftheday.services.prizeService.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    @PostMapping("/home/newPrize")
    public String newPrize(@Valid Prize newprize) {
        Prize p = new Prize(0, RootController.currentListId, newprize.getPrize(), 0);
        this.prizeService.insertNewPrize(p);
        RootController.campaignsRedirect = false;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = true;
        return "redirect:/home";
    }

    @PostMapping("/home/deletePrize")
    public String deletePrize(@Valid Prize newprize) {
        this.prizeService.deletePrize(newprize.getId());
        RootController.campaignsRedirect = false;
        RootController.wordsRedirect = false;
        RootController.prizesRedirect = true;
        return "redirect:/home";
    }

}
