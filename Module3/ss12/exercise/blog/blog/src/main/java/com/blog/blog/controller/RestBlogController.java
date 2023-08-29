package com.blog.blog.controller;

import com.blog.blog.model.Blog;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> categoryList(@RequestBody int page) {
        Pageable pageable = PageRequest.of(page, 3);
        List<Blog> blogList = (List<Blog>) blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> blogDetail(@PathVariable int id) {
        Blog blog = blogService.findById(id).get();
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}