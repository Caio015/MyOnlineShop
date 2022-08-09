package com.github.caio015.myonlineshop.product.domain.dto;

import com.github.caio015.myonlineshop.product.domain.model.Category;
import lombok.Value;

@Value
public class CategoryDto {

    Long id;

    String name;

    public static Category toCategory(CategoryDto categoryDto){

        return new Category(categoryDto.getId(),
                            categoryDto.getName());
    }
}
