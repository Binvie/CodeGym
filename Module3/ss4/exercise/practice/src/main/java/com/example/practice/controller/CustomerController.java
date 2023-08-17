package com.example.practice.controller;

import com.example.practice.repository.ICustomerRepository;
import com.example.practice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public String home(){
        return "/list";
    }
}
