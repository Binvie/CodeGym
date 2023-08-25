package com.example.book_management.repository;

import com.example.book_management.model.Book;
import com.example.book_management.model.Customer;
import com.example.book_management.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where name like :name",nativeQuery = true)
    Page<Customer> findAll(Pageable pageable, @Param("name") String name);

}
