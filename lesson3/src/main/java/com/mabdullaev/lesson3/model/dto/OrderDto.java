package com.mabdullaev.lesson3.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Long id;

    private String orderNum;

    private ClientDto client;
}
