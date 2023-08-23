package com.blog.blog.controller;

import com.blog.blog.model.Blog;
import com.blog.blog.repository.ICategoryRepository;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryRepository categoryRepository;
    @GetMapping("")
    public String list(@RequestParam(defaultValue = "0",required = false)int page, Model model){
        Pageable pageable = PageRequest.of(page,3);
        model.addAttribute("lists",blogService.findAll(pageable));
        return "/list";
    }
    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/create","blog",new Blog());
        modelAndView.addObject("categoryList",categoryRepository.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createBlog(Blog blog){
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message","Add new blog successfully");
        return modelAndView;
    }
//    @GetMapping("/edit/{id}")
//    public ModelAndView editForm(@PathVariable int id){
//        Optional<Blog> blog = blogService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/edit","blog",blog);
//        modelAndView.addObject("categoryList",categoryRepository.findAll());
//        return modelAndView;
//    }
//    @PostMapping("/edit")
//    public ModelAndView editBlog(Blog blog){
//        blogService.update(blog.getId(), blog);
//        ModelAndView modelAndView = new ModelAndView("/edit");
//        modelAndView.addObject("message","Edit successfully");
//        return modelAndView;
//    }
//    @GetMapping("/delete/{id}")
//    public ModelAndView deleteForm(@PathVariable int id){
//        Optional<Blog> blog = blogService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/delete","blog",blog);
//        return modelAndView;
//    }
//    @PostMapping("/delete")
//    public ModelAndView deleteBlog(Blog blog){
//        blogService.deleteById(blog.getId());
//        ModelAndView modelAndView = new ModelAndView("/delete");
//        modelAndView.addObject("message","Delete successfully");
//        return modelAndView;
//    }
}
