package com.example.book_management.repository;

import com.example.book_management.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetail,Integer> {
}
