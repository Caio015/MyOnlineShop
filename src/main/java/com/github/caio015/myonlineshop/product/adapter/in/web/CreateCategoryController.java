package com.github.caio015.myonlineshop.product.adapter.in.web;

import com.github.caio015.myonlineshop.product.application.CreateCategoryUseCase;
import com.github.caio015.myonlineshop.product.domain.request.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class CreateCategoryController {
    private final CreateCategoryUseCase createCategory;

    @PostMapping(path = "/create-category")
    public ResponseEntity<Void> createCategory(@RequestBody CreateCategoryRequest request){

        createCategory.execute(request);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
