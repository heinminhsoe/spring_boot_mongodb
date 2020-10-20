package com.hms.sbmgdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductDto {
    private String id;
    private String code;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
