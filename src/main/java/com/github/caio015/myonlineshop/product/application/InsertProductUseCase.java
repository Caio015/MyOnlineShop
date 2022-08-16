package com.github.caio015.myonlineshop.product.application;

import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import com.github.caio015.myonlineshop.product.domain.request.InsertProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsertProductUseCase {
    private final SaveProductPort saveProduct;

    @Transactional
    public void execute(InsertProductRequest request){

        Product product = Product.builder()
                                 .productName(request.getProductName())
                                 .description(request.getDescription())
                                 .urlImage(request.getUrlImage())
                                 .price(request.getPrice())
                                 .quantity(request.getQuantity())
                                 .category(request.getCategory())
                                 .build();

        saveProduct.save(product);
    }
}
