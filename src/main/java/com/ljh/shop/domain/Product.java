package com.ljh.shop.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
