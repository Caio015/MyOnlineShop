package com.github.caio015.myonlineshop.product.application.port.out;

public interface VerifyIfProductAlreadyExistsPort {

    boolean verifyIfProductExistsByName(String productName);
}
