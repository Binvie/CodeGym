package com.blog.blog.service;

import com.blog.blog.model.Blog;

public interface IGenerateService<T> {
    Iterable<T> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
}
