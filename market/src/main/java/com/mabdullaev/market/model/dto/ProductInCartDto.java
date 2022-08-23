package com.mabdullaev.market.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInCartDto {
    private Long userId;
    private Long productId;
    private Integer quantity;
}
