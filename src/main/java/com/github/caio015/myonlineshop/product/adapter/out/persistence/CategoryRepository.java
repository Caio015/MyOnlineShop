package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.domain.dto.CategoryDto;
import com.github.caio015.myonlineshop.product.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT new com.github.caio015.myonlineshop.product.domain.dto.CategoryDto(" +
           "c.id, " +
           "c.name) " +
           "FROM Category c " +
           "WHERE c.id = :id")
    Optional<CategoryDto> findCategoryDtoById(Long id);


    @Query("SELECT COUNT(*) > 0 FROM Category c WHERE c.name = :name")
    boolean existsByName(String name);

}
