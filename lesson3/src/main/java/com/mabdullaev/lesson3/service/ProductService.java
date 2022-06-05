package com.mabdullaev.lesson3.service;

import com.mabdullaev.lesson3.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto findById(Long id);

    void addProduct(ProductDto productDto);

    void deleteProduct(long id);

    void inc(Long id);

    void dec(Long id);

    List<ProductDto> findAll();

    List<ProductDto> getProductsByClient(Long clientId);
}
