package com.mabdullaev.lesson7.model.dao;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name ="products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

}
