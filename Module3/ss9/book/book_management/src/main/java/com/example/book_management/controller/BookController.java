package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.service.utils.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page
            , @RequestParam(defaultValue = "", required = false) Optional<String> searchName, Model model) {
        String name = "";
        if (searchName.isPresent()){
            name = searchName.get();
        }
        Pageable pageable = PageRequest.of(page, 3);
        Page<Book> bookPage = bookService.findAll(pageable,name);
        model.addAttribute("bookList", bookPage);
        return "/list";
    }
}
