package com.github.caio015.myonlineshop.customer.application;

import com.github.caio015.myonlineshop.customer.application.port.out.FindCustomerByIdPort;
import com.github.caio015.myonlineshop.customer.application.port.out.SaveCustomerPort;
import com.github.caio015.myonlineshop.customer.domain.dto.CustomerDTO;
import com.github.caio015.myonlineshop.customer.domain.model.Customer;
import com.github.caio015.myonlineshop.customer.domain.request.EditCustomerDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditCustomerDetailsUseCase {

    private final FindCustomerByIdPort findCustomerById;

    private final SaveCustomerPort saveCustomer;

    private final CustomerVerificationService verificationService;

    public CustomerDTO execute(Long customerId, EditCustomerDetailsRequest request) {

        verificationService.verifyCustomerRequestService(request);

        Customer customer = findCustomerById.findCustomerById(customerId);

        customer.getPersonalDetails().editPersonalDetails(request);

        saveCustomer.saveCustomer(customer);

        return CustomerDTO.of(customer);

    }
}
