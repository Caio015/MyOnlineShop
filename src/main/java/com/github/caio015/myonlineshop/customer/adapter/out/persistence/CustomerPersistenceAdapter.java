package com.github.caio015.myonlineshop.customer.adapter.out.persistence;

import com.github.caio015.myonlineshop.customer.application.port.out.DeleteCustomerByIdPort;
import com.github.caio015.myonlineshop.customer.application.port.out.FindCustomerByIdPort;
import com.github.caio015.myonlineshop.customer.application.port.out.SaveCustomerPort;
import com.github.caio015.myonlineshop.customer.application.port.out.VerifyIfEmailOrCpfIsAlreadyRegisteredPort;
import com.github.caio015.myonlineshop.customer.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements SaveCustomerPort,
                                                   VerifyIfEmailOrCpfIsAlreadyRegisteredPort,
                                                   DeleteCustomerByIdPort, FindCustomerByIdPort {

    private final CustomerRepository repository;

    @Override
    public void saveCustomer(Customer customer) {

        repository.save(customer);
    }

    public boolean customerAlreadyRegistered(String cpf, String email) {

        return repository.verifyIfCpfAndEmailAlreadyRegistered(cpf, email);
    }

    @Override
    public void deleteCustomerById(Long customerId) {

        repository.deleteById(customerId);
    }

    @Override
    public Customer findCustomerById(Long customerId) {

        return repository.findById(customerId).orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }
}
