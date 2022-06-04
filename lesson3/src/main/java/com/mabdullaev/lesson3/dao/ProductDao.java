package com.mabdullaev.lesson3.dao;

import com.mabdullaev.lesson3.model.dao.Product;

import java.util.List;

public interface ProductDao {
    public Product findById(Long id);
    public List<Product> findAll();
    public void deleteById(Long id);
    public void saveOrUpdate(Product product);

}
