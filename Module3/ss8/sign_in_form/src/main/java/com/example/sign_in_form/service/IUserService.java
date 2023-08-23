package com.example.sign_in_form.service;

import com.example.sign_in_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(int id);
    void save(User user);
}
