package com.github.caio015.myonlineshop.product.application;

import com.github.caio015.myonlineshop.config.exceptions.BusinessRuleException;
import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.application.port.out.VerifyIfProductAlreadyExistsPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import com.github.caio015.myonlineshop.product.domain.request.InsertProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsertProductUseCase {

    private final VerifyIfProductAlreadyExistsPort verifyIfProductAlreadyExists;
    private final SaveProductPort saveProduct;

    @Transactional
    public void execute(InsertProductRequest request){

        verifyIfProductAlreadyExists(request);

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

    private void verifyIfProductAlreadyExists(InsertProductRequest request) {

        if (verifyIfProductAlreadyExists.verifyIfProductExistsByName(request.getProductName())) {

            throw new BusinessRuleException("Product already exists");
        }
    }
}
