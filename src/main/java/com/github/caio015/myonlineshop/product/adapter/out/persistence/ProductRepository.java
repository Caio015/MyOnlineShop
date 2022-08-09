package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
