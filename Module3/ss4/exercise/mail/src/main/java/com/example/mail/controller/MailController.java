package com.example.mail.controller;

import com.example.mail.model.Mail;
import com.example.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IMailService mailService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("list", mailService.display());
        return "home";
    }

    @GetMapping("/edit")
    public String edit(Model model, @ModelAttribute Mail mail) {
        model.addAttribute("mail", mail);
        return "home";
    }
}
