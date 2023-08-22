package com.blog.blog.service;

import com.blog.blog.model.Blog;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();
    Optional<T> findById(int id);
    void save(Blog blog);
    void delete(int id);
}
