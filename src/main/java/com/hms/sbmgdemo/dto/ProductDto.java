package com.hms.sbmgdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductDto {
    @ApiModelProperty(readOnly = true, example = "1001")
    private String id;

    @ApiModelProperty(value = "Code of product", required = true, example = "ITM001")
    @NotBlank(message = "Product code must not be null or empty")
    private String code;

    @ApiModelProperty(value = "Description of product", required = true, example = "iPhone 12")
    @NotBlank(message = "Product description must not be null or empty")
    private String description;

    @ApiModelProperty(value = "Price of the product", required = true, example = "1000.00")
    @NotNull(message = "Product price must not be null")
    private BigDecimal price;

    @ApiModelProperty(value = "Quantity of the product", required = true, example = "10")
    @NotNull(message = "Product quantity must not be null")
    private Integer quantity;
}
