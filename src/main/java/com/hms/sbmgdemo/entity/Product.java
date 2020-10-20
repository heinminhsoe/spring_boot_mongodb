package com.hms.sbmgdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Product {
    @Id
    private ObjectId id;
    private String code;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant lastModifiedAt;
}
