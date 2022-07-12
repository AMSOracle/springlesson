package com.mabdullaev.lesson.services;

import com.mabdullaev.lesson.exceptions.ResourceNotFoundException;
import com.mabdullaev.lesson.model.dao.Product;
import com.mabdullaev.lesson.model.dto.ProductDto;
import com.mabdullaev.lesson.repositories.ProductRepository;
import com.mabdullaev.lesson.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final Mapper mapper;

    public Page<ProductDto> findAll(int pageIndex, int pageSize){
        return productRepository.findAll(PageRequest.of(pageIndex,pageSize)).map(mapper::daoToDto);
    }
    public ProductDto findById(Long id) {
        return mapper.daoToDto(productRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product with id=" + id + " not found")));
    }

    public ProductDto create(ProductDto productDto) {
        Product product = mapper.dtoToDao(productDto);
        //clear ID as it's set by Database
        product.setId(null);
        return mapper.daoToDto(productRepository.save(product));
    }

    public ProductDto upd(ProductDto productDto){
        //check if product exists
        findById(productDto.getId());
        Product product = mapper.dtoToDao(productDto);
        return mapper.daoToDto(productRepository.save(product));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
