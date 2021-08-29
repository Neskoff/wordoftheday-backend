package com.rbt.wordoftheday.webControllers;

import com.rbt.wordoftheday.domain.Admin;
import com.rbt.wordoftheday.services.adminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String getLoginPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @PostMapping("/loginAction")
    public String logInAdmin(@Valid Admin admin, HttpServletResponse httpServletResponse) throws IOException {
        if (this.adminService.adminExists(admin.getUsername(), admin.getPassword())) {
            RootController.currentAdmin = admin.getUsername();
            httpServletResponse.sendRedirect("/home");
            return null;
        } else
            return "login";
    }
}
