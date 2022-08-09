package com.github.caio015.myonlineshop.product.domain.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductDto {

    Long productId;

    String productName;

    String urlImage;

    BigDecimal quantity;

    BigDecimal price;
}
