package com.github.caio015.myonlineshop.product.domain.request;

import com.github.caio015.myonlineshop.product.domain.model.Category;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class InsertProductRequest {

     String productName;

     String description;

     String urlImage;

     Integer quantity;

     BigDecimal price;

     Category category;

}
