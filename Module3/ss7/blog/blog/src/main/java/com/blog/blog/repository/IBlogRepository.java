package com.blog.blog.repository;

import com.blog.blog.model.Blog;
import com.blog.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "SELECT * FROM blog WHERE category_id = :categoryId;", nativeQuery = true)
    Page<Blog> findCategory(@Param("categoryId") int categoryId, Pageable pageable);
    @Query(value = "select * from blog order by number_page;", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);
    @Query(value = "select * form blog where id = :id;", nativeQuery = true)
    Optional<Blog> findById(@Param("id") int id);
    @Transactional
    @Modifying
    @Query(value = "delete from blog where id = :id;", nativeQuery = true)
    Blog deleteById(@Param("id") int id);
    @Transactional
    @Modifying
    @Query(value = "insert into blog(title, number_page, content, category_id) value( :#{#blog.title} ,:#{#blog.numberPage},:#{#blog.content},:#{#blog.category.categoryId});", nativeQuery = true)
    void saveBlog(@Param("blog") Blog blog);
//    @Transactional
//    @Modifying
//    @Query(value = "update blog set title = :#{#blog.title}, number_page = :#{#blog.numberPage}, content = :#{#blog.content}, category_id = :#{#blog.category.categoryId} where id = :id ", nativeQuery = true)
//    void update(@Param("id") int id, Blog blog);
    @Query(value = "SELECT * FROM blog WHERE  title like :name;", nativeQuery = true)
    Page<Blog> findCategoryName(@Param("name")String name, Pageable pageable);
}
