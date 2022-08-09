package com.github.caio015.myonlineshop.product.application.port.out;

import com.github.caio015.myonlineshop.product.domain.dto.CategoryDto;

public interface FindCategoryByIdPort {

    CategoryDto findCategoryDtoByIdPort(Long categoryId);

}
