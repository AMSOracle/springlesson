package com.mabdullaev.lesson2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Setter
@Component
@Scope("singleton")
public class ProductRepository {

    private int printCount;
    private TreeMap<Integer, Product> productList;

    public ProductRepository() {
        productList = new TreeMap<>();

        productList.put(1, new Product(1, "Apple", 1));
        productList.put(2, new Product(2, "Pear", 2));
        productList.put(3, new Product(3, "Orange", 3));
        productList.put(4, new Product(4, "Onion", 4));
        productList.put(5, new Product(5, "Banana", 5));
        productList.put(6, new Product(6, "Milk", 6));
        productList.put(7, new Product(7, "Avocado", 7));
        productList.put(8, new Product(8, "Grapes", 8));
        productList.put(9, new Product(9, "Carrot", 9));
        productList.put(10, new Product(10, "Lemon", 10));
    }

    public Product getProduct(int id) {
        return productList.get(id);
    }

    public void printProducts() {
        System.out.println("printed: " + printCount);
        for (Product p : productList.values()
        ) {
            System.out.println(p);
        }
        printCount++;
    }

}
