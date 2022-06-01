package com.mabdullaev.lesson3.service;

import com.mabdullaev.lesson3.dao.ProductDao;
import com.mabdullaev.lesson3.model.Mapper;
import com.mabdullaev.lesson3.model.dto.ProductDto;
import com.mabdullaev.lesson3.model.dao.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@Scope("singleton")
public class ProductService {

    private final ProductDao productDao;
    private final Mapper mapper;

    public ProductService(ProductDao productDao, Mapper mapper) {
        this.productDao = productDao;
        this.mapper = mapper;
    }

    public ProductDto findById(Long id) {
        return mapper.daoToDto(productDao.findById(id));
    }

    public void addProduct(ProductDto productDto){
        Product product = mapper.dtoToDao(productDto);
        productDao.saveOrUpdate(product);
        productDto = mapper.daoToDto(product);
    }

    public void deleteProduct(long id){
        productDao.deleteById(id);
    }

    public void inc(Long id) {
        Product product = productDao.findById(id);
        product.setPrice(product.getPrice() + 1);
        productDao.saveOrUpdate(product);
    }

    public void dec(Long id) {
        Product product = productDao.findById(id);
        if (product.getPrice() > 1) {
            product.setPrice(product.getPrice() - 1);
            productDao.saveOrUpdate(product);
        }
    }

    public List<ProductDto> findAll(){
        List<Product> products = productDao.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p: products) {
            productDtos.add(mapper.daoToDto(p));
        }
        return productDtos;
    }

}
