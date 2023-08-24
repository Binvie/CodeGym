package com.example.book_management.service.classService;

import com.example.book_management.model.Book;
import com.example.book_management.repository.IBookRepository;
import com.example.book_management.service.utils.IBookService;
import com.example.book_management.service.utils.IGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Book> findAll(Pageable pageable, String name) {
        return bookRepository.findAll(pageable, "%" + name + "%");
    }
}
