package com.github.caio015.myonlineshop.product.application;

import com.github.caio015.myonlineshop.product.application.port.out.SaveProductPort;
import com.github.caio015.myonlineshop.product.domain.model.Category;
import com.github.caio015.myonlineshop.product.domain.model.Product;
import com.github.caio015.myonlineshop.product.domain.request.InsertProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsertProductUseCase {
    private final FindCategoryByIdPort findCategory;
    private final SaveProductPort saveProduct;

    @Transactional
    public void execute(InsertProductRequest request){

        Category category = CategoryDto.toCategory(findCategory.findCategoryDtoByIdPort(request.getCategoryId()));

        Product product = Product.builder()
                                 .productName(request.getProductName())
                                 .description(request.getDescription())
                                 .urlImage(request.getUrlImage())
                                 .price(request.getPrice())
                                 .category(category)
                                 .build();

        saveProduct.save(product);
    }
}
