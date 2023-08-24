package com.example.book_management.service.utils;

import com.example.book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends IGenerateService<Book> {
    Page<Book> findAll(Pageable pageable, String name);
}
