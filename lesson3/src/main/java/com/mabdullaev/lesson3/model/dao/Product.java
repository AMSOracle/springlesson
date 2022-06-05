package com.mabdullaev.lesson3.model.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQueries(
        {
                @NamedNativeQuery(name = "GetProductsByClient",
                        query = "select " +
                                "    p.id, p.name, sp.price " +
                                " from" +
                                "    products p " +
                                " join order_spec sp " +
                                "    on (p.id = sp.product_id)" +
                                " join orders ord " +
                                "    on (ord.id = sp.order_id)" +
                                " join clients c " +
                                "    on (ord.client_id = c.id)" +
                                " where " +
                                "    c.id = :client_id",
                        resultClass = Product.class)
        }
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
