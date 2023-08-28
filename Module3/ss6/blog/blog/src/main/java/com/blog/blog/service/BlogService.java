package com.blog.blog.service;

import com.blog.blog.model.Blog;
import com.blog.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }
}
