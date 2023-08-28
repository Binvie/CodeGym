package com.example.book_management.service.utils;

import com.example.book_management.model.Book;
import com.example.book_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenerateService<Customer> {
    Page<Customer> findAll(Pageable pageable,String name);
    Customer findCustomerByName(String name);
}
