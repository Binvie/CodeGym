package com.example.controller;

import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping("")
    public String home(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customer",customers);
        return "list";
    }
    @GetMapping("create")
    public String showCreateCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("create")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Add successfully");
        return "redirect:/customer";
    }
}
