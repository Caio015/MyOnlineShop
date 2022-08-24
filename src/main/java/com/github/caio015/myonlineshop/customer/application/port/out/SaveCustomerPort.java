package com.github.caio015.myonlineshop.customer.application.port.out;

import com.github.caio015.myonlineshop.customer.domain.model.Customer;

public interface SaveCustomerPort {

    void saveCustomer(Customer customer);

}
