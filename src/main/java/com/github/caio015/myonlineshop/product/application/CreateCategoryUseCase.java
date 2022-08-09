package com.github.caio015.myonlineshop.product.application;

import com.github.caio015.myonlineshop.config.exceptions.BusinessRuleException;
import com.github.caio015.myonlineshop.product.application.port.out.ExistsCategoryWithThisNamePort;
import com.github.caio015.myonlineshop.product.application.port.out.SaveCategoryPort;
import com.github.caio015.myonlineshop.product.domain.model.Category;
import com.github.caio015.myonlineshop.product.domain.request.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final ExistsCategoryWithThisNamePort findCategoryByName;
    private final SaveCategoryPort saveCategory;

    public void execute(CreateCategoryRequest request) {

        if (findCategoryByName.findCategoryByName(request.getName())) {

            throw new BusinessRuleException("Category already exists");
        }

        Category category = new Category(request.getName());

        saveCategory.saveCategory(category);
    }
}
