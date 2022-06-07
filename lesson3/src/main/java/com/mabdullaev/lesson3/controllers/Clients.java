package com.mabdullaev.lesson3.controllers;

import com.mabdullaev.lesson3.model.dto.ClientDto;
import com.mabdullaev.lesson3.model.dto.ProductDto;
import com.mabdullaev.lesson3.service.ClientService;
import com.mabdullaev.lesson3.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class Clients {

    private final ClientService clientService;
    private final ProductService productService;

    public Clients(ClientService clientService, ProductService productService) {
        this.clientService = clientService;
        this.productService = productService;
    }

    @GetMapping
    @ResponseBody
    public List<ClientDto> showClients(){
        return clientService.showClients();
    }

    @GetMapping("/product/{clientId}")
    @ResponseBody
    public List<ProductDto> getProductsByClient(@PathVariable Long clientId){
        return productService.getProductsByClient(clientId);
    }

}
