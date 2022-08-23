package com.mabdullaev.market.util;

import com.mabdullaev.market.model.dao.CartItem;
import com.mabdullaev.market.model.dao.Product;
import com.mabdullaev.market.model.dto.ProductDto;
import com.mabdullaev.market.model.dto.ProductInCartDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface MarketMapper {

    Product map(ProductDto productDto);

    ProductDto map(Product product);

    CartItem mapCartItem(ProductInCartDto productInCartDto);

}
