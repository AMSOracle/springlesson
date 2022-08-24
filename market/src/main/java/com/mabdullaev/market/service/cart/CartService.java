package com.mabdullaev.market.service.cart;


import com.mabdullaev.market.model.dao.Cart;
import com.mabdullaev.market.model.dao.CartItem;
import com.mabdullaev.market.model.dao.Product;
import com.mabdullaev.market.model.dto.ProductDto;
import com.mabdullaev.market.model.dto.ProductInCartDto;
import com.mabdullaev.market.service.product.ProductService;
import com.mabdullaev.market.util.MarketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductService productService;
    private final MarketMapper mapper;

    @Cacheable(value = "cart")
    public Cart getCart(Long userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setItems(new HashMap<>());
        return cart;
    }

    @CacheEvict(value = "cart")
    public void clearCart(Long userId){

    }

    @CachePut(value = "cart", key = "#productInCartDto.userId")
    public Cart addToCart(Cart cart, ProductInCartDto productInCartDto) {
        ProductDto productDto = productService.findById(productInCartDto.getProductId());
        CartItem item;
        if (cart.getItems().containsKey(productDto.getId())) {
            item = cart.getItems().get(productDto.getId());
        } else {
            item = mapper.mapCartItem(productInCartDto);
        }
        item.setPrice(productDto.getPrice());
        item.setTitle(productDto.getName());
        item.setTotal(BigDecimal.valueOf(productInCartDto.getQuantity()).multiply(productDto.getPrice()));
        cart.getItems().put(productDto.getId(), item);
        return cart;
    }

    @CachePut(value = "cart", key = "#productInCartDto.userId")
    public Cart delete(Cart cart, ProductInCartDto productInCartDto) {
        cart.getItems().remove(productInCartDto.getProductId());
        return cart;
    }
}
