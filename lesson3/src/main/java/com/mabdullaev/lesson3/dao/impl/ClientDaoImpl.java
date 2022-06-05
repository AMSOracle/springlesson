package com.mabdullaev.lesson3.dao.impl;

import com.mabdullaev.lesson3.dao.ClientDao;
import com.mabdullaev.lesson3.model.dao.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDaoImpl implements ClientDao {

    private final SessionFactory sessionFactory;

    public ClientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> showClients() {
        List<Client> clients = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            clients = session.createQuery("from Client").getResultList();
            session.getTransaction().commit();
        }
        return clients;
    }

    @Override
    public List<Client> getClientsByProduct(Long productId) {
        List<Client> clients = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<Client> query = session.createNamedQuery("GetClientsByProduct",Client.class);
            query.setParameter("product_id", productId);
            clients = query.getResultList();
            session.getTransaction().commit();
        }
        return clients;
    }
}
