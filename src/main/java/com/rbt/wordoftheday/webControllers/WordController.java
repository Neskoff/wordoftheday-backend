package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.services.wordService.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.Root;
import javax.validation.Valid;

@Controller
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping("/home/insertWordOfTheDay")
    public String insertWOTD(@Valid Word word) {
        if (word.getWord().length() > 3 && (!word.getWord()
                .equals(RootController.currentWordOfTheDay.getWord()))) {
            this.wordService.resetWordOfTheDay();
            word.setWordOfTheDay(true);
            if (this.wordService.insertWordOfTheDay(word))
                RootController.resultSet = "WordSuccess";
        } else
            RootController.resultSet = "WordFail";
        RootController.wordsRedirect = true;
        RootController.campaignsRedirect = false;
        return "redirect:/home";
    }

    @PostMapping("/home/insertFromList")
    public String insertList(@Valid Word word) {
        if (!word.getWord().equals(RootController.currentWordOfTheDay.getWord()) &&
                (word.getWord().length() > 3)) {
            this.wordService.resetWordOfTheDay();
            if (this.wordService.updateWordOfTheDay(word.getWord()))
                RootController.resultSet = "WordSuccess";

        } else
            RootController.resultSet = "WordFail";
        RootController.wordsRedirect = true;
        RootController.campaignsRedirect = false;
        return "redirect:/home";
    }


}
