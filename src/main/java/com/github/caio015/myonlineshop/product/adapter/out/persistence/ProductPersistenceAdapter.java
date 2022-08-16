package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.application.port.out.FindProductByIdPort;
import com.github.caio015.myonlineshop.product.application.port.out.RemoveProductFromCatalogPort;
import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.application.port.out.VerifyIfProductAlreadyExistsPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort,
                                                  VerifyIfProductAlreadyExistsPort,
                                                  FindProductByIdPort, RemoveProductFromCatalogPort {

    private final ProductRepository repository;
    @Override
    public void save(Product product) {

        repository.save(product);
    }

    @Override
    public boolean verifyIfProductExistsByName(String productName) {

        return repository.verifyIfProductExistsByName(productName);
    }

    @Override
    public Product findProductById(Long productId) {

        return repository.findById(productId).orElseThrow(() -> new NoSuchElementException("No product found with this id"));
    }

    @Override
    public void removeProduct(Long productId) {

        repository.deleteById(productId);
    }
}
