package com.github.caio015.myonlineshop.product.adapter.in.web;

import com.github.caio015.myonlineshop.product.application.InsertProductUseCase;
import com.github.caio015.myonlineshop.product.domain.request.InsertProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin/product")
@RequiredArgsConstructor
public class InsertProductController {

    private final InsertProductUseCase insertProduct;

    @PostMapping(path = "/insert-product")
    public ResponseEntity<Void> insertProduct(@RequestBody InsertProductRequest request) {

        insertProduct.execute(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}