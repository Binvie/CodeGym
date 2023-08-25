package com.example.book_management.service.classService;

import com.example.book_management.model.Category;
import com.example.book_management.repository.ICategoryRepository;
import com.example.book_management.service.utils.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remove(int id) {

    }
}
