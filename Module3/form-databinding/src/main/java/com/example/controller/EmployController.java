package com.example.controller;

import com.example.model.Employee;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public String showList(Model model) {
        List<Employee> employees = employeeService.display();
        model.addAttribute("employees", employees);
        return "/home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("employee",new Employee());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@RequestParam Employee employee, RedirectAttributes redirectAttributes){
        employeeService.create(employee);
        redirectAttributes.addFlashAttribute("mess","Create successfully");
        return "redirect:/employee";
    }
}
