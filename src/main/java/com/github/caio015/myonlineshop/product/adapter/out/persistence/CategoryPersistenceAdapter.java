package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.application.port.out.FindCategoryByIdPort;
import com.github.caio015.myonlineshop.product.application.port.out.ExistsCategoryWithThisNamePort;
import com.github.caio015.myonlineshop.product.application.port.out.SaveCategoryPort;
import com.github.caio015.myonlineshop.product.domain.dto.CategoryDto;
import com.github.caio015.myonlineshop.product.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements FindCategoryByIdPort,
                                                   ExistsCategoryWithThisNamePort,
                                                   SaveCategoryPort {

    private final CategoryRepository repository;

    @Override
    public CategoryDto findCategoryDtoByIdPort(Long categoryId) {

        return repository.findCategoryDtoById(categoryId).orElseThrow(() -> new NoSuchElementException("The category doesn't exist"));
    }

    @Override
    public boolean findCategoryByName(String name) {

        return repository.existsByName(name);
    }

    @Override
    public void saveCategory(Category category) {

        repository.save(category);
    }
}
