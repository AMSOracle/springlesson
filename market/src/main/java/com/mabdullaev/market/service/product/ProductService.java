package com.mabdullaev.market.service.product;


import com.mabdullaev.market.exceptions.ResourceNotFoundException;
import com.mabdullaev.market.model.dao.Product;
import com.mabdullaev.market.model.dto.ProductDto;
import com.mabdullaev.market.repositories.ProductRepository;
import com.mabdullaev.market.util.MarketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MarketMapper mapper;

    public Page<ProductDto> findAll(int pageIndex, int pageSize){
        return productRepository.findAll(PageRequest.of(pageIndex,pageSize)).map(mapper::map);
    }
    public ProductDto findById(Long id) {
        return mapper.map(productRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Product with id=" + id + " not found")));
    }

    public ProductDto create(ProductDto productDto) {
        Product product = mapper.map(productDto);
        //clear ID as it's set by Database
        product.setId(null);
        return mapper.map(productRepository.save(product));
    }

    public ProductDto upd(ProductDto productDto){
        //check if product exists
        findById(productDto.getId());

        return mapper.map(productRepository.save(mapper.map(productDto)));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

}
