package com.mabdullaev.market.controllers;

import com.mabdullaev.market.model.dao.Cart;
import com.mabdullaev.market.model.dao.CartItem;
import com.mabdullaev.market.model.dto.ProductDto;
import com.mabdullaev.market.model.dto.ProductInCartDto;
import com.mabdullaev.market.service.cart.CartService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public Cart getCart(@RequestParam Long userId){
       return cartService.getCart(userId);
    }

    @PostMapping("/add")
    public Cart add(@RequestBody ProductInCartDto productInCartDto){
        Cart cart = cartService.getCart(productInCartDto.getUserId());
        return cartService.addToCart(cart, productInCartDto);
    }

    @PostMapping("/clear")
    public ResponseEntity<?> clear(@RequestParam Long userId){
        cartService.clearCart(userId);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/del")
    public Cart deleteById(@RequestBody ProductInCartDto productInCartDto) {
        Cart cart = cartService.getCart(productInCartDto.getUserId());
        return cartService.delete(cart, productInCartDto);
    }

}