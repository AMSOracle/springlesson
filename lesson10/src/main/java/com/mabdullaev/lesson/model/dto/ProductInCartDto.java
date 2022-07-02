package com.mabdullaev.lesson.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInCartDto {
    private Long id;
    private int total;
    private int quantity;
    ProductDto product;
}
