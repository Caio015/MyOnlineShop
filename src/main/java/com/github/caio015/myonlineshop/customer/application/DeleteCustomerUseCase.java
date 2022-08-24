package com.github.caio015.myonlineshop.customer.application;

import com.github.caio015.myonlineshop.customer.application.port.out.DeleteCustomerByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final DeleteCustomerByIdPort deleteCustomer;

    public void execute(Long customerId) {

        //TODO Insert Validations;

        deleteCustomer.deleteCustomerById(customerId);

    }
}
