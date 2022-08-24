package com.mabdullaev.market.controllers;

import com.mabdullaev.market.model.dto.ProductDto;
import com.mabdullaev.market.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 10);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.upd(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }


}
