package com.blog.blog.controller;

import com.blog.blog.model.Blog;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("lists",blogService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/create","blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createBlog(Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message","Add new blog successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        Optional blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit","blog",new Blog());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView editBlog(Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("message","Edit successfully");
        return modelAndView;
    }
}
