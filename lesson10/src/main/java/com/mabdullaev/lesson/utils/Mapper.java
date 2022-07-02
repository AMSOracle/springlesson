package com.mabdullaev.lesson.utils;


import com.mabdullaev.lesson.model.dao.Product;
import com.mabdullaev.lesson.model.dao.ProductInCart;
import com.mabdullaev.lesson.model.dto.ProductDto;
import com.mabdullaev.lesson.model.dto.ProductInCartDto;
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

    public ProductInCartDto daoToDto(ProductInCart dao){
        if (dao ==null){
            return null;
        }
        ProductInCartDto productDto = new ProductInCartDto();
        productDto.setId(dao.getId());
        productDto.setTotal(dao.getTotal());
        productDto.setQuantity(dao.getQuantity());
        productDto.setProduct(daoToDto(dao.getProduct()));
        return productDto;
    }
}
