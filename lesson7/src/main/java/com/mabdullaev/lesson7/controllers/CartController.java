package com.mabdullaev.lesson7.controllers;

import com.mabdullaev.lesson7.model.dto.CartModifyDto;
import com.mabdullaev.lesson7.model.dto.ProductInCartDto;
import com.mabdullaev.lesson7.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public Page<ProductInCartDto> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return cartService.findAll(pageIndex - 1, 10);
    }

    @GetMapping("/{id}")
    public ProductInCartDto findById(@PathVariable Long id) {
        return cartService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductInCartDto add(@RequestBody CartModifyDto cartModifyDto) {
        return cartService.saveOrUpdate(cartModifyDto);
    }

    @PutMapping("/inc")
    public ProductInCartDto inc(@RequestParam(name = "id") Optional<Long> id, @RequestParam(value = "productId", required = false) Optional<Long> productId) {
        return cartService.inc(id, productId);
    }
    @PutMapping("/dec")
    public ProductInCartDto dec(@RequestParam(name = "id") Optional<Long> id, @RequestParam(value = "productId", required = false) Optional<Long> productId) {
        return cartService.dec(id, productId);
    }
    @PutMapping
    public ProductInCartDto upd(@RequestBody CartModifyDto cartModifyDto) {
        return cartService.saveOrUpdate(cartModifyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        cartService.deleteById(id);
    }


}