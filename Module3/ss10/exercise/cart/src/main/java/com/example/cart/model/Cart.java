package com.example.cart.model;

import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Cart {
    private Map<Product, Integer> productMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    private Boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (Boolean.FALSE.equals(checkItemInCart(product))) {
            productMap.put(product, 1);
        } else {
            Map.Entry<Product, Integer> item = selectItemInCart(product);
            Integer amount = item.getValue() + 1;
            productMap.replace(item.getKey(), amount);
        }
    }
    public Integer countProductQuantity(){
        Integer quantity = 0;
        for (Map.Entry<Product,Integer> entry : productMap.entrySet()){
            quantity += entry.getValue();
        }return quantity;
    }
    public Float totalPayment(){
        float payment = 0;
        for (Map.Entry<Product,Integer> entry : productMap.entrySet()){
            payment += (float) (entry.getValue() * entry.getKey().getPrice());
        }return  payment;
    }
}
