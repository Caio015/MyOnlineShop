package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort {

    private final ProductRepository repository;
    @Override
    public void save(Product product) {

        repository.save(product);
    }
}
