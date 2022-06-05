package com.mabdullaev.lesson3.service.impl;

import com.mabdullaev.lesson3.dao.OrderDao;
import com.mabdullaev.lesson3.model.dao.Order;
import com.mabdullaev.lesson3.model.dao.OrderItem;
import com.mabdullaev.lesson3.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> showOrders() {
        return orderDao.showOrders();
    }

    @Override
    public List<OrderItem> showOrderSpec(Long orderId) {
        return orderDao.showOrderSpec(orderId);
    }
}
