package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product",Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Product product) {
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public Product findById(int id) {
        Product product = entityManager.find(Product.class,id);
        return product;
    }

    @Override
    @Transactional
    public void update(int id, Product product) {
        entityManager.merge(findById(id));
    }

    @Override
    @Transactional
    public void remove(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE LOWER(p.name) = LOWER(:name)", Product.class);
        query.setParameter("name", name);
        System.out.println(query.getResultList().size());
        return query.getResultList();
    }
}
