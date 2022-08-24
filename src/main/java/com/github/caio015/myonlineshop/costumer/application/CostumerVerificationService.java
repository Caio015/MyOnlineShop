package com.github.caio015.myonlineshop.costumer.application;

import com.github.caio015.myonlineshop.config.exceptions.BusinessRuleException;
import com.github.caio015.myonlineshop.config.exceptions.InvalidInsertDataException;
import com.github.caio015.myonlineshop.costumer.application.port.out.VerifyIfEmailOrCpfIsAlreadyRegisteredPort;
import com.github.caio015.myonlineshop.costumer.domain.request.RegisterCostumerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostumerVerificationService {

   private final VerifyIfEmailOrCpfIsAlreadyRegisteredPort findCostumerByCpfOrEmail;

    //We can use bean validation for most of this validations but i'm doing it for practice purpouse;


    public void verifyIfCpfOrEmailAlreadyUsed(RegisterCostumerRequest request) {

        if(findCostumerByCpfOrEmail.costumerAlreadyRegistered(request.getCpf(), request.getEmail())){

            throw new BusinessRuleException("CPF or Email already used");
        }
    }

    public void verifyCpfLenght(String cpf){

        if(cpf.length() != 14){
            throw new InvalidInsertDataException("Please insert a valid CPF");
        }
    }

    public void verifyStateLenght(String state){

        if(state.length() != 2){

            throw new InvalidInsertDataException("A state must have 2 characters");
        }
    }

    public void verifyPhoneLenght(String number){

        if(number.length() != 9){

            throw new InvalidInsertDataException("Please insert a valid phone number");
        }
    }

    public void verifyCepLenght(String cep){

        if(cep.length() != 9) {

            throw new InvalidInsertDataException("Please insert a valid CEP");
        }
    }

}
