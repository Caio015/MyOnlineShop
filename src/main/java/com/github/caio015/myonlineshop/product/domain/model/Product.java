package com.github.caio015.myonlineshop.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;

    private String productName;

    private String description;

    private String urlImage;

    private Integer quantity;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private Integer rating;

}
