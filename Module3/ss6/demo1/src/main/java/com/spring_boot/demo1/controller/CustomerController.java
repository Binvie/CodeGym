package com.spring_boot.demo1.controller;

import com.spring_boot.demo1.model.Customer;
import com.spring_boot.demo1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create","customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        Optional<Customer> customer = customerService.findById(id);
//        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/edit","customer",customer);
            return modelAndView;
        }
//        else {
//            return new ModelAndView("/error_404");
//        }
//    }
    @PostMapping("/edit")
    public ModelAndView editCustomer(Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id){
        Optional<Customer> customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete","customer",customer.get());
        return modelAndView;
    }
    @PostMapping("/delete")
    public  String deleteCustomer(Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }
}
