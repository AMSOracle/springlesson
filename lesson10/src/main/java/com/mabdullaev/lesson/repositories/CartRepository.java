package com.mabdullaev.lesson.repositories;

import com.mabdullaev.lesson.model.dao.Product;
import com.mabdullaev.lesson.model.dao.ProductInCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<ProductInCart, Long> {
    List<ProductInCart> findAll();
    Optional<ProductInCart> findByProduct(Product product);
}
