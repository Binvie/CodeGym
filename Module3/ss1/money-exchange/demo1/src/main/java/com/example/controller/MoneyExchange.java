package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyExchange {
    @GetMapping("")
    public String exchange() {
        return "view";
    }

    @PostMapping("/view")
    public String exchange1(@RequestParam int number1, Model model) {
        int number2 = number1 * 23000;
        model.addAttribute("number2", number2);
        return "view";
    }
}
