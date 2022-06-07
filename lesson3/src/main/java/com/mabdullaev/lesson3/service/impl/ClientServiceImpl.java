package com.mabdullaev.lesson3.service.impl;

import com.mabdullaev.lesson3.dao.ClientDao;
import com.mabdullaev.lesson3.model.Mapper;
import com.mabdullaev.lesson3.model.dao.Client;
import com.mabdullaev.lesson3.model.dto.ClientDto;
import com.mabdullaev.lesson3.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final Mapper mapper;

    public ClientServiceImpl(ClientDao clientDao, Mapper mapper) {
        this.clientDao = clientDao;
        this.mapper = mapper;
    }

    @Override
    public List<ClientDto> showClients() {
        List<ClientDto> dtos = new ArrayList<>();
        for ( Client dao: clientDao.showClients()) {
            ClientDto clientDto = mapper.daoToDto(dao);
            if (clientDto != null){
                dtos.add(clientDto);
            }
        }
        return dtos;
    }

    @Override
    public List<ClientDto> getClientsByProduct(Long productId) {
        List<ClientDto> dtos = new ArrayList<>();
        for ( Client dao: clientDao.getClientsByProduct(productId)) {
            ClientDto clientDto = mapper.daoToDto(dao);
            if (clientDto != null){
                dtos.add(clientDto);
            }
        }
        return dtos;
    }
}
