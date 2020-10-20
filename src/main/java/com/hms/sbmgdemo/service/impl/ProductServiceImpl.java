package com.hms.sbmgdemo.service.impl;

import com.hms.sbmgdemo.dto.ProductDto;
import com.hms.sbmgdemo.entity.Product;
import com.hms.sbmgdemo.exception.EntityNotFoundException;
import com.hms.sbmgdemo.mapper.ProductMapper;
import com.hms.sbmgdemo.repository.ProductRepository;
import com.hms.sbmgdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository){
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productRepository.save(
                productMapper.fromDto(productDto)
        );
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto update(ProductDto productDto) {

        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(
                        () -> new EntityNotFoundException()
                );

        product = product.toBuilder()
                .code(productDto.getCode())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

        product = productRepository.save(product);

        return productMapper.toDto(product);
    }

    @Override
    public void delete(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException()
                );

        productRepository.delete(product);
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toDtos(
                productRepository.findAll()
        );
    }

    @Override
    public ProductDto findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException()
                );
        return productMapper.toDto(product);
    }
}
