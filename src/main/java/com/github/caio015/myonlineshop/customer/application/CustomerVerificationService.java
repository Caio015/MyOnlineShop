package com.github.caio015.myonlineshop.customer.application;

import com.github.caio015.myonlineshop.config.exceptions.BusinessRuleException;
import com.github.caio015.myonlineshop.config.exceptions.InvalidInsertDataException;
import com.github.caio015.myonlineshop.customer.application.port.out.VerifyIfEmailOrCpfIsAlreadyRegisteredPort;
import com.github.caio015.myonlineshop.customer.domain.model.Verifiable;
import com.github.caio015.myonlineshop.customer.domain.request.RegisterCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerVerificationService {

   private final VerifyIfEmailOrCpfIsAlreadyRegisteredPort findCustomerByCpfOrEmail;

    //We can use bean validation for most of this validations but i'm doing it for practice purpouse;


    public void verifyIfCpfOrEmailAlreadyUsed(RegisterCustomerRequest request) {

        if(findCustomerByCpfOrEmail.customerAlreadyRegistered(request.getCpf(), request.getEmail())){

            throw new BusinessRuleException("CPF or Email already used");
        }
    }

    private void verifyCpfLenght(String cpf){

        if(cpf.length() != 14){
            throw new InvalidInsertDataException("Please insert a valid CPF");
        }
    }

    private void verifyStateLenght(String state){

        if(state.length() != 2){

            throw new InvalidInsertDataException("A state must have 2 characters");
        }
    }

    private void verifyPhoneLenght(String number){

        if(number.length() != 9){

            throw new InvalidInsertDataException("Please insert a valid phone number");
        }
    }

    private void verifyCepLenght(String cep){

        if(cep.length() != 9) {

            throw new InvalidInsertDataException("Please insert a valid CEP");
        }
    }

    public void verifyCustomerRequestService(Verifiable request){

        verifyCepLenght(request.getCep());

        verifyCpfLenght(request.getCpf());

        request.getPhoneNumber().forEach(phoneRequest -> verifyPhoneLenght(phoneRequest.getNumber()));

        verifyStateLenght(request.getState());

    }

}
