package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sandwich")
public class Sandwich {
    @GetMapping("")
    public String home() {
        return "/home";
    }

    @PostMapping("/save")
    public String ingredient(@RequestParam(name = "condiments",required = false,defaultValue = "hay nhap lia")  List<String> list, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("list", list);
        return "redirect:/sandwich";
    }
}
