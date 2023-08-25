package com.example.book_management.service.classService;

import com.example.book_management.model.OrderDetail;
import com.example.book_management.repository.IOrderRepository;
import com.example.book_management.service.utils.IOrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<OrderDetail> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderRepository.save(orderDetail);
    }

    @Override
    public void remove(int id) {
        orderRepository.deleteById(id);
    }
}
