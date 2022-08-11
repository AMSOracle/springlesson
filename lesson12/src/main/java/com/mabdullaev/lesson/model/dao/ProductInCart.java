package com.mabdullaev.lesson.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="cart")
@Data
//@NamedNativeQuery( name = "ProductInCart.findAllProducts", query = "select c.id, c.product_id, c.quantity, c.price, c.total from cart c join products p on p.id = c.product_id ", resultClass = ProductInCart.class)
public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private int price;
    @Column(name = "total")
    private int total;
    @ManyToOne
    Product product;
}
