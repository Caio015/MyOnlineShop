package com.github.caio015.myonlineshop.customer.adapter.out.persistence;

import com.github.caio015.myonlineshop.customer.application.port.out.SaveCustomerPort;
import com.github.caio015.myonlineshop.customer.application.port.out.VerifyIfEmailOrCpfIsAlreadyRegisteredPort;
import com.github.caio015.myonlineshop.customer.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements SaveCustomerPort,
                                                   VerifyIfEmailOrCpfIsAlreadyRegisteredPort {

    private final CustomerRepository repository;

    @Override
    public void saveCustomer(Customer customer) {

        repository.save(customer);
    }

    public boolean customerAlreadyRegistered(String cpf, String email) {

        return repository.verifyIfCpfAndEmailAlreadyRegistered(cpf, email);
    }
}
