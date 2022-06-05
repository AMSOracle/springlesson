package com.mabdullaev.lesson3.dao;

import com.mabdullaev.lesson3.model.dao.Client;

import java.util.List;

public interface ClientDao {
    List<Client> showClients();
    List<Client> getClientsByProduct(Long productId);
}
