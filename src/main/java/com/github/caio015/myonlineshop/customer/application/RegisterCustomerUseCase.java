package com.github.caio015.myonlineshop.customer.application;

import com.github.caio015.myonlineshop.customer.application.port.out.SaveCustomerPort;
import com.github.caio015.myonlineshop.customer.application.port.out.SaveUserPort;
import com.github.caio015.myonlineshop.customer.domain.dto.CustomerDTO;
import com.github.caio015.myonlineshop.customer.domain.model.Customer;
import com.github.caio015.myonlineshop.customer.domain.model.PersonalDetails;
import com.github.caio015.myonlineshop.customer.domain.model.User;
import com.github.caio015.myonlineshop.customer.domain.request.RegisterCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCustomerUseCase {

    private final SaveCustomerPort saveCustomer;

    private final SaveUserPort saveUser;

    private final CreatePersonalDetailsService createPersonalDetails;

    private final CustomerVerificationService verificationService;

    @Transactional
    public CustomerDTO execute(RegisterCustomerRequest request) {

        verificationService.verifyIfCpfOrEmailAlreadyUsed(request);

        verificationService.verifyCustomerRequestService(request);

        PersonalDetails personalDetails = createPersonalDetails.generatePersonalDetails(request);

        User user = User.createUser(request);

        saveUser.saveUser(user);

        Customer customer = Customer.createCustomer(personalDetails, user);

        saveCustomer.saveCustomer(customer);

        return CustomerDTO.of(customer);
    }
}
