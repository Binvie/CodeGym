package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calculate")
public class Calculator {
    @GetMapping("")
    public String home() {
        return "/home";
    }

    @PostMapping("/save")
    public String calculate(RedirectAttributes redirectAttributes, @RequestParam(name = "operator")
    Character operator, @RequestParam int number1, @RequestParam int number2) {
        int result = 0;
        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '/') {
            if (number2 == 0) {
                redirectAttributes.addFlashAttribute("message", "can't divide by 0");
            } else result = number1 / number2;
        } else if (operator == 'x') {
            result = number1 * number2;
        }
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/calculate";
    }
}
