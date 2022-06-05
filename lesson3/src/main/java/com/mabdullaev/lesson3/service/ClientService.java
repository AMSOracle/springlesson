package com.mabdullaev.lesson3.service;


import com.mabdullaev.lesson3.model.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> showClients();

    List<ClientDto> getClientsByProduct(Long productId);
}
