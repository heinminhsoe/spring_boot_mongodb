package com.hms.sbmgdemo.controller;

import com.hms.sbmgdemo.controller.api.ProductAPI;
import com.hms.sbmgdemo.dto.ProductDto;
import com.hms.sbmgdemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController implements ProductAPI {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(
                productService.findAll(),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<ProductDto> findById(String id) {
        return new ResponseEntity<>(
                productService.findById(id),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<ProductDto> create(ProductDto product) {
        return new ResponseEntity<>(
                productService.save(product),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<ProductDto> update(String id, ProductDto product) {
        return new ResponseEntity<>(
                productService.update(id, product),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
