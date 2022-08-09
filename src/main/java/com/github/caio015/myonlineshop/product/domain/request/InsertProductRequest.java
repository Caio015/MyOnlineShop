package com.github.caio015.myonlineshop.product.domain.request;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class InsertProductRequest {

     String productName;

     String description;

     String urlImage;

     Integer quantity;

     BigDecimal price;

     Long categoryId;

}
