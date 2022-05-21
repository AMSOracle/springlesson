package com.mabdullaev.lesson2.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private int price;
}
