package com.blog.blog.service;

import com.blog.blog.model.Blog;
import com.blog.blog.model.Category;
import com.blog.blog.repository.IBlogRepository;
import com.blog.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findCategory(int categoryId, Pageable pageable) {
        return blogRepository.findCategory(categoryId, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog deleteById(int id) {
        return blogRepository.deleteById(id);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.saveBlog(blog);
    }

    @Override
    public void update(int id, Blog blog) {
//        blogRepository.update(id, blog);
    }

    @Override
    public Page<Blog> findCategoryName(String name, Pageable pageable) {
        return blogRepository.findCategoryName(name, pageable);
    }
}
