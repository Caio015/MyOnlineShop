package com.github.caio015.myonlineshop.product.application.port.out;

import com.github.caio015.myonlineshop.product.domain.model.Category;

public interface SaveCategoryPort {

    void saveCategory(Category category);

}
