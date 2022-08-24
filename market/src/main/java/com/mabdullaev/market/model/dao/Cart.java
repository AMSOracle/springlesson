package com.mabdullaev.market.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {
        private  long userId;
        private HashMap<Long, CartItem> items;
}
