package com.github.caio015.myonlineshop.product.domain.model;

import com.github.caio015.myonlineshop.product.domain.request.EditProductRequest;
import lombok.*;

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

    private Integer inStock;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer rating;


    public void editProduct(EditProductRequest request){

        this.productName = request.getProductName();
        this.description = request.getDescription();
        this.urlImage = request.getUrlImage();
        this.inStock = request.getInStock();
        this.price = request.getPrice();
        this.category = request.getCategory();

    }

}
