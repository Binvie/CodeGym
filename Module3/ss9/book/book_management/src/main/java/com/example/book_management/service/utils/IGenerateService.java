package com.example.book_management.service.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T> {
    List<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(Long id);
}
