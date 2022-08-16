package com.github.caio015.myonlineshop.product.adapter.in.web;

import com.github.caio015.myonlineshop.product.application.RemoveProductFromCatalogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/product")
public class RemoveProductFromCatalogController {

    private final RemoveProductFromCatalogUseCase useCase;

    @DeleteMapping(path = "/remove-product/{productId}")
    public ResponseEntity<Void> removeProductFromSystem(@PathVariable Long productId){

        useCase.execute(productId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
