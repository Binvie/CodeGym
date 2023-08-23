package com.blog.blog.service;

import com.blog.blog.model.Blog;
import com.blog.blog.model.Category;
import com.blog.blog.repository.ICategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findCategory(@Param("categoryId") int categoryId, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(@Param("id") int id);

    Blog deleteById(@Param("id") int id);

    void saveBlog(@Param("blog") Blog blog);

    void update(@Param("id") int id, Blog blog);

    Page<Blog> findCategoryName(@Param("name") String name, Pageable pageable);
}
