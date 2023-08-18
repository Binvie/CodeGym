package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository implements IProductRepository{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Laptop", 1000, "good"));
        products.put(2, new Product(2, "keyboard", 500, "beautiful"));
        products.put(3, new Product(3, "AirCondition", 9000, "Sai Gon"));
        products.put(4, new Product(4, "Smart Phone", 7000, "Beijing"));
        products.put(5, new Product(5, "PC", 8000, "Miami"));
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>(products.values());
        return productList;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        List<Product> productList1 = findAll();
        for (int i = 0; i < productList1.size(); i++) {
            if (productList1.get(i).getName().contains(name)){
                productList.add(productList1.get(i));
            }
        }
        return productList;
    }
}
