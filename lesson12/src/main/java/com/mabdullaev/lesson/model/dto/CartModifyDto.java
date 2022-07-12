package com.mabdullaev.lesson.model.dto;

import lombok.Data;

@Data
public class CartModifyDto {
    private Long id;
    private Long productId;
    private Integer quantity;

}
