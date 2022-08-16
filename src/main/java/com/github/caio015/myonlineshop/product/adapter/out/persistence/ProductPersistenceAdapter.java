package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.application.port.out.VerifyIfProductAlreadyExistsPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort, VerifyIfProductAlreadyExistsPort {

    private final ProductRepository repository;
    @Override
    public void save(Product product) {

        repository.save(product);
    }

    @Override
    public boolean verifyIfProductExistsByName(String productName) {

        return repository.verifyIfProductExistsByName(productName);
    }
}
