package com.mabdullaev.market.model.dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class CartItem implements Serializable {

    long productId;
    int quantity;
    BigDecimal price;
    BigDecimal total;
    String title;
}
