package com.github.caio015.myonlineshop.product.adapter.in.web;

import com.github.caio015.myonlineshop.product.application.EditProductUseCase;
import com.github.caio015.myonlineshop.product.domain.request.EditProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin/product")
@RequiredArgsConstructor
public class EditProductController {

    private final EditProductUseCase useCase;

    @PatchMapping(path = "edit-product/{productId}")
    public ResponseEntity<Void> editProduct(@PathVariable Long productId,
                                            @RequestBody EditProductRequest request){

        useCase.execute(productId, request);

        return new ResponseEntity(HttpStatus.OK);

    }

}
