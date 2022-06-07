package com.mabdullaev.lesson7.services;

import com.mabdullaev.lesson7.model.dao.Product;
import com.mabdullaev.lesson7.model.dto.ProductDto;
import com.mabdullaev.lesson7.repositories.ProductRepository;
import com.mabdullaev.lesson7.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final Mapper mapper;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(new Product());
    }

    public void save(ProductDto productDto){
        Product product = mapper.dtoToDao(productDto);
        productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> filterByPrice(Integer min, Integer max){
        if ((min == null) && (max != null)){
            return productRepository.findAllByPriceBefore(max);
        }else if(min != null && max == null){
            return productRepository.findAllByPriceAfter(min);
        }else if(min!= null && max != null){
            return productRepository.findAllByPriceBetween(min, max);
        } else{
            return findAll();
        }
    }
}
