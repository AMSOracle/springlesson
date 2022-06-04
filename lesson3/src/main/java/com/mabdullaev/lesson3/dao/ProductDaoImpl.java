package com.mabdullaev.lesson3.dao;

import com.mabdullaev.lesson3.model.dao.Product;
import com.mabdullaev.lesson3.model.dto.ProductDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
        }
        return products;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
