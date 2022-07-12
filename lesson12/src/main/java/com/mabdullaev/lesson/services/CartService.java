package com.mabdullaev.lesson.services;

import com.mabdullaev.lesson.exceptions.ResourceNotFoundException;
import com.mabdullaev.lesson.model.dao.Product;
import com.mabdullaev.lesson.model.dao.ProductInCart;
import com.mabdullaev.lesson.model.dto.CartModifyDto;
import com.mabdullaev.lesson.model.dto.ProductInCartDto;
import com.mabdullaev.lesson.repositories.CartRepository;
import com.mabdullaev.lesson.repositories.ProductRepository;
import com.mabdullaev.lesson.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService  {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    private final Mapper mapper;

    public Page<ProductInCartDto> findAll(int pageIndex, int pageSize){
        return cartRepository.findAll(PageRequest.of(pageIndex,pageSize)).map(mapper::daoToDto);
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }

    public ProductInCartDto inc(Optional<Long> id, Optional<Long> productId){
        ProductInCart productInCart = null;
        if(id.isPresent()) {
            productInCart = cartRepository.findById(id.get()).orElseThrow(() -> new ResourceNotFoundException("Product missing " + id.get()));
        } else if (productId.isPresent()) {
            Product product = productRepository.findById(productId.get()).orElseThrow(() -> new ResourceNotFoundException("Product " + productId.get() + " not found"));
            productInCart = cartRepository.findByProduct(product).orElseGet(ProductInCart::new);
            productInCart.setProduct(product);
        } else {
            throw  new ResourceNotFoundException("Product not found");
        }
        productInCart.setQuantity(productInCart.getQuantity() + 1);
        productInCart.setPrice(productInCart.getProduct().getPrice());
        productInCart.setTotal(productInCart.getQuantity() * productInCart.getPrice());

        productInCart = cartRepository.save(productInCart);
        return mapper.daoToDto(productInCart);
    }

    public ProductInCartDto dec(Optional<Long> id, Optional<Long> productId){
        ProductInCart productInCart = null;
        if(id.isPresent()) {
            productInCart = cartRepository.findById(id.get()).orElseThrow(() -> new ResourceNotFoundException("Product missing " + id.get()));

        } else if (productId.isPresent()) {
            Product product = productRepository.findById(productId.get()).orElseThrow(() -> new ResourceNotFoundException("Product " + productId.get() + " not found"));
            productInCart = cartRepository.findByProduct(product).orElseThrow(() -> new ResourceNotFoundException("Product " + productId.get() + " not found"));
            productInCart.setProduct(product);
        } else {
            throw  new ResourceNotFoundException("Product not found");
        }
        if (productInCart.getQuantity() <= 1) {
            cartRepository.deleteById(productInCart.getId());
            return null;
        } else {
            productInCart.setQuantity(productInCart.getQuantity() - 1);
            productInCart.setPrice(productInCart.getProduct().getPrice());
            productInCart.setTotal(productInCart.getQuantity() * productInCart.getPrice());
            productInCart = cartRepository.save(productInCart);
        }

        return mapper.daoToDto(productInCart);
    }

    public ProductInCartDto saveOrUpdate(CartModifyDto cartModifyDto) {
        Product product = productRepository.findById(cartModifyDto.getProductId()).orElseThrow(() ->new ResourceNotFoundException("Product "+ cartModifyDto.getProductId() + " not found"));
        ProductInCart productInCart = null;
        if (cartModifyDto.getId() == null) {
            productInCart = new ProductInCart();
        } else {
            productInCart = cartRepository.findById(cartModifyDto.getId()).orElseGet(ProductInCart::new);;
        }
        productInCart.setProduct(product);
        productInCart.setQuantity(cartModifyDto.getQuantity());
        productInCart.setPrice(product.getPrice());
        productInCart.setTotal(productInCart.getQuantity() * productInCart.getPrice());
        productInCart = cartRepository.save(productInCart);
        return mapper.daoToDto(productInCart);
    }

    public ProductInCartDto findById(Long id){
        return mapper.daoToDto(cartRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Cart item =" + id + " not found")));
    }

}
