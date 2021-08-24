package com.rbt.wordoftheday.webcontroller;

import com.rbt.wordoftheday.domain.Admin;
import com.rbt.wordoftheday.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/")
public class webController {
@Autowired
private AdminService adminService;
private String currentAdmin;

    @GetMapping("/")
    public String getLoginPage(Model model){
        model.addAttribute("admin", new Admin());
        return "login";
    }
    @GetMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("name",currentAdmin);
        if (currentAdmin == null)
        return "redirect:/";
        else
        return "index";
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
}
