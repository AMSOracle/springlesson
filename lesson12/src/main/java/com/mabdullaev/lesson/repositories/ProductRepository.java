package com.mabdullaev.lesson.repositories;

import com.mabdullaev.lesson.model.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(Integer min, Integer max);
    List<Product> findAllByPriceAfter(Integer min);
    List<Product> findAllByPriceBefore(Integer max);
}
