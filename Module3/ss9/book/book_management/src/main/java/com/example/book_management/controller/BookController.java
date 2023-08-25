package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.model.Category;
import com.example.book_management.model.Customer;
import com.example.book_management.service.utils.IBookService;
import com.example.book_management.service.utils.ICategoryService;
import com.example.book_management.service.utils.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page
            , @RequestParam(defaultValue = "", required = false) Optional<String> searchName, Model model) {
        String name = "";
        if (searchName.isPresent()) {
            name = searchName.get();
        }
        Pageable pageable = PageRequest.of(page, 3);
        Page<Book> bookPage = bookService.findAll(pageable, name);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("bookList", bookPage);
        model.addAttribute("categoryList", categoryList);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailBook(@PathVariable int id) {
        Optional<Book> book = bookService.findById(id);
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/detail", "book", book.get());
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @PostMapping("/detail/{id}")
    public ModelAndView rentBook(@PathVariable int id) {
        Optional<Book> book  = bookService.findById(id);
        if (book.get().getQuantity() < 1) {
            ModelAndView modelAndView1 = new ModelAndView("/error-404");
            return modelAndView1;
        }
        book.get().setQuantity(book.get().getQuantity() - 1);
        ModelAndView modelAndView = new ModelAndView("/books");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
}
