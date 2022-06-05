package com.mabdullaev.lesson3.dao;

import com.mabdullaev.lesson3.model.dao.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    void saveOrUpdate(Product product);
    List<Product> getProductsByClient(long clientId);
}
