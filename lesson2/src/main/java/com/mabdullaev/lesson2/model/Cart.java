package com.mabdullaev.lesson2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

@Getter
@Setter
@Component
@Scope("prototype")
public class Cart {
    private final ProductRepository productRepository;
    private int printCount;
    private TreeMap<Integer, ProductInCart> products;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        products = new TreeMap<>();
    }

    public void addProductToCart(int id, int delta) {
        Product product = productRepository.getProduct(id);
        if (product == null) {
            return;
        }
        //increment quantity
        if (products.containsKey(product.getId())) {
            products.get(product.getId()).incQuantity(delta);
        } else {
            ProductInCart productInCart = new ProductInCart();
            products.put(product.getId(), productInCart);
            productInCart.setQuantity(1);
            productInCart.setId(product.getId());
            productInCart.setName(product.getName());
            productInCart.setPrice(product.getPrice());
        }
    }

    public void removeProductFromCart(int id) {
        products.remove(id);
    }

    public void printCart() {
        System.out.println("printed: " + printCount);
        for (ProductInCart p : products.values()
        ) {
            System.out.println(p);
        }
        printCount++;
    }


}
