package com.example.controller;


import com.example.service.IProductService;
import com.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("")
    public String home(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "list";
    }
    @GetMapping("create")
    public String showCreateCustomer(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("create")
    public String createCustomer(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Add successfully");
        return "redirect:/product";
    }
    @GetMapping("edit")
    public String showEditCustomer(Model model, @RequestParam int id){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess","Edit successfully");
        return "redirect:/product";
    }
    @GetMapping("delete")
    public String deleteForm(@RequestParam int id , RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Delete successfully");
        return "redirect:/product";
    }
    @PostMapping("search")
    public String searchName(@RequestParam String word , Model model){
        List<Product> products = productService.searchByName(word);
        model.addAttribute("products",products);
        System.out.println(products.size());
        return "list";
    }
}
