package com.hms.sbmgdemo.mapper;

import com.hms.sbmgdemo.dto.ProductDto;
import com.hms.sbmgdemo.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product fromDto(ProductDto dto) {
        Product product = Product.builder()
                .code(dto.getCode())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .build();

        if(!StringUtils.isEmpty(dto.getId()))
            product.setId(new ObjectId(dto.getId()));

        return product;
    }

    public ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId().toHexString())
                .code(entity.getCode())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    public List<ProductDto> toDtos(Iterable<Product> entityList) {
        List<ProductDto> productDtos = new ArrayList<>();
        entityList.forEach(
                (product) -> productDtos.add(toDto(product))
        );
        return productDtos;
    }
}