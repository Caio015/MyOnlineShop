package com.github.caio015.myonlineshop.product.adapter.out.persistence;

import com.github.caio015.myonlineshop.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT COUNT(*) > 0 FROM Product p WHERE p.productName = :productName")
    boolean verifyIfProductExistsByName(String productName);
}
