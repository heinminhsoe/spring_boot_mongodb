package com.hms.sbmgdemo.controller.api;

import com.hms.sbmgdemo.dto.ProductDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Product API")
@RequestMapping("api/product")
public interface ProductAPI {

    @ApiOperation(value = "Get products", nickname = "getProducts", response = ProductDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll();

    @ApiOperation(value = "Get a product by ID.", nickname = "getProductById", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") String id);

    @ApiOperation(value = "Create product", nickname = "createProduct", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto product);

    @ApiOperation(value = "Update product", nickname = "updateProduct", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable("id") String id, @Valid @RequestBody ProductDto product);

    @ApiOperation(value = "Delete product", nickname = "deleteProduct")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id);
}
