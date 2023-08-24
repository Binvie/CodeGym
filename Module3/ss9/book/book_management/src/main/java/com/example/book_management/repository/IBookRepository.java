package com.example.book_management.repository;

import com.example.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from book where name like :name",nativeQuery = true)
    Page<Book> findAll(Pageable pageable, @Param("name") String name);


}
