package com.example.book_management.repository;

import com.example.book_management.model.Book;
import com.example.book_management.model.Category;
import com.example.book_management.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select * from category",nativeQuery = true)
    List<Category> findAll();
}
