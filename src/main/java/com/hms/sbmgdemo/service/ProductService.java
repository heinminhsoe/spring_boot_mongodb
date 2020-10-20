package com.hms.sbmgdemo.service;

import com.hms.sbmgdemo.dto.ProductDto;
import com.hms.sbmgdemo.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto findById(String id);

    ProductDto save(ProductDto product);

    ProductDto update(ProductDto product);

    void delete(String id);
}
