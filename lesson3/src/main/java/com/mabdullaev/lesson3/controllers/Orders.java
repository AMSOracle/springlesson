package com.mabdullaev.lesson3.controllers;

import com.mabdullaev.lesson3.model.dao.Order;
import com.mabdullaev.lesson3.model.dao.OrderItem;
import com.mabdullaev.lesson3.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class Orders {

    private final OrderService service;

    public Orders(OrderService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<Order> showOrders(){
        return service.showOrders();
    }

    @GetMapping("/spec/{id}")
    @ResponseBody
    public List<OrderItem> showOrderSpec(@PathVariable Long id){
        return service.showOrderSpec(id);
    }
}
