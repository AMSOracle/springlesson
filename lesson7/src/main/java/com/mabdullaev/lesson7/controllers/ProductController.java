package com.mabdullaev.lesson7.controllers;

import com.mabdullaev.lesson7.model.dao.Product;
import com.mabdullaev.lesson7.model.dto.ProductDto;
import com.mabdullaev.lesson7.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ProductDto productDto){
        productService.save(productDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(Long id){
        productService.deleteById(id);
    }

    @GetMapping("/filterByPrice")
    public List<Product> filterByPrice(@RequestParam(required = false) Integer min, @RequestParam(required = false) Integer max){
        return productService.filterByPrice(min,max);
    }

}
