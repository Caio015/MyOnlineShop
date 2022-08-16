package com.github.caio015.myonlineshop.product.application.port.out;

import com.github.caio015.myonlineshop.product.domain.model.Product;

public interface FindProductByIdPort {

    Product findProductById(Long productId);
}
