package com.github.caio015.myonlineshop.product.application;

import com.github.caio015.myonlineshop.config.exceptions.BusinessRuleException;
import com.github.caio015.myonlineshop.product.application.port.out.FindProductByIdPort;
import com.github.caio015.myonlineshop.product.application.port.out.RemoveProductFromCatalogPort;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveProductFromCatalogUseCase {

    private final FindProductByIdPort findProduct;

    private final RemoveProductFromCatalogPort removeProduct;

    public void execute(Long productId){

        Product product = findProduct.findProductById(productId);

        verifyIfThereIsItensOnInventory(product);

        removeProduct.removeProduct(productId);

    }

    private void verifyIfThereIsItensOnInventory(Product product) {

        if(product.getInStock() > 0) {

            throw new BusinessRuleException("Can't remove a product that has itens in inventory");
        }
    }

}
