package com.mabdullaev.lesson3.dao.impl;

import com.mabdullaev.lesson3.dao.OrderDao;
import com.mabdullaev.lesson3.model.dao.Order;
import com.mabdullaev.lesson3.model.dao.OrderItem;
import com.mabdullaev.lesson3.model.dao.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Order> showOrders() {
        List<Order> orders = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orders = session.createQuery("from Order").getResultList();
            session.getTransaction().commit();
        }
        return orders;
    }

    @Override
    public List<OrderItem> showOrderSpec(Long orderId) {
        return null;
    }
}
