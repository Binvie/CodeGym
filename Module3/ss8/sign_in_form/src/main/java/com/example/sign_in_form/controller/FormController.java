package com.example.sign_in_form.controller;

import com.example.sign_in_form.model.User;
import com.example.sign_in_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class FormController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("lists", iUserService.findAll());
        return "/view";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("user",new User());
        return "/create";
    }
    @PostMapping("/create")
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {

        ModelAndView modelAndView ;
        if (bindingResult.hasFieldErrors()){
            modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iUserService.save(user);
        modelAndView = new ModelAndView("create","message","create successfully");
        return modelAndView ;
    }
}
