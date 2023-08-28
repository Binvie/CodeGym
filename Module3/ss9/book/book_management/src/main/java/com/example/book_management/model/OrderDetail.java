package com.example.book_management.model;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id" , referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "customer_id" , referencedColumnName = "id")
    private Customer customer;
    private int code;

    public OrderDetail() {
    }

    public OrderDetail(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
    }

    public OrderDetail(int id, Book book, Customer customer) {
        this.id = id;
        this.book = book;
        this.customer = customer;
    }

    public OrderDetail(int id, Book book, Customer customer, int code) {
        this.id = id;
        this.book = book;
        this.customer = customer;
        this.code = (int) (10000 + Math.random() * 89999);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
