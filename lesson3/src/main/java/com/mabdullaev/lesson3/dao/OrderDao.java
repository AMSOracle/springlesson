package com.mabdullaev.lesson3.dao;

import com.mabdullaev.lesson3.model.dao.Order;
import com.mabdullaev.lesson3.model.dao.OrderItem;

import java.util.List;

public interface OrderDao {
    List<Order> showOrders();
    List<OrderItem> showOrderSpec(Long orderId);
}
