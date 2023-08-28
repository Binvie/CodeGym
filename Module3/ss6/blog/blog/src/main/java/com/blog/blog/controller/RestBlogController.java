package com.blog.blog.controller;

import com.blog.blog.model.Blog;
import com.blog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Blog> findAll() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>((Blog) blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@RequestBody int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        if (blog == null)
        return  new ResponseEntity<>(blogService.save(blog),HttpStatus.CREATED);

    }
}
