package com.hms.sbmgdemo.controller;

import com.hms.sbmgdemo.dto.ProductDto;
import com.hms.sbmgdemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(
                productService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable String id) {
        return new ResponseEntity<>(
                productService.findById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product) {
        return new ResponseEntity<>(
                productService.save(product),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto product) {
        return new ResponseEntity<>(
                productService.update(product),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
