package com.mabdullaev.lesson3.model;

import com.mabdullaev.lesson3.model.dao.Client;
import com.mabdullaev.lesson3.model.dao.Product;
import com.mabdullaev.lesson3.model.dto.ClientDto;
import com.mabdullaev.lesson3.model.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Product dtoToDao(ProductDto dto){
        if (dto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return product;
    }

    public ProductDto daoToDto(Product dao){
        if (dao ==null){
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(dao.getId());
        productDto.setName(dao.getName());
        productDto.setPrice(dao.getPrice());
        return productDto;
    }


    public ClientDto daoToDto(Client dao){
        if (dao == null){
            return null;
        }
        ClientDto dto = new ClientDto();
        dto.setId(dao.getId());
        dto.setName(dao.getName());
        return dto;
    }
}
