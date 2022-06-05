package com.mabdullaev.lesson3.service;

import com.mabdullaev.lesson3.model.dao.Order;
import com.mabdullaev.lesson3.model.dao.OrderItem;

import java.util.List;

public interface OrderService {
    List<Order> showOrders();
    List<OrderItem> showOrderSpec(Long orderId);
}
