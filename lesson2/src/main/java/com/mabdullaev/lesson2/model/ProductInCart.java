package com.mabdullaev.lesson2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class ProductInCart extends Product {
    private int quantity;

    public ProductInCart() {
        this.quantity = 0;
    }

    public ProductInCart(int id, String name, int price, int quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    public void incQuantity(int delta) {
        this.quantity += delta;
    }
}
