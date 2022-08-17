package com.github.caio015.myonlineshop.product.application;

import com.github.caio015.myonlineshop.product.application.port.out.FindProductByIdPort;
import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import com.github.caio015.myonlineshop.product.domain.request.EditProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProductUseCase {

    private final FindProductByIdPort findProduct;

    private final SaveProductPort saveProduct;

    public void execute(Long productId, EditProductRequest request) {

        Product product = findProduct.findProductById(productId);

        product.editProduct(request);

        saveProduct.save(product);

    }
}
