package com.rbt.wordoftheday.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class webController {

    @GetMapping("/")
    public String getHomePage(Model model){
        model.addAttribute("name","ilija");
        return "index";
    }
}
