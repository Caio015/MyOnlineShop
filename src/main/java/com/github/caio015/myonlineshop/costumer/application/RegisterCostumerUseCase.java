package com.github.caio015.myonlineshop.costumer.application;

import com.github.caio015.myonlineshop.config.exceptions.BusinessRuleException;
import com.github.caio015.myonlineshop.costumer.application.port.out.SaveCostumerPort;
import com.github.caio015.myonlineshop.costumer.application.port.out.SaveUserPort;
import com.github.caio015.myonlineshop.costumer.application.port.out.VerifyIfEmailOrCpfIsAlreadyRegisteredPort;
import com.github.caio015.myonlineshop.costumer.domain.dto.CostumerDTO;
import com.github.caio015.myonlineshop.costumer.domain.model.*;
import com.github.caio015.myonlineshop.costumer.domain.request.RegisterCostumerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCostumerUseCase {

    private final SaveCostumerPort saveCostumer;

    private final SaveUserPort saveUser;

    private final CreatePersonalDetailsService createPersonalDetails;

    private final VerifyIfEmailOrCpfIsAlreadyRegisteredPort findCostumerByCpfOrEmail;


    @Transactional
    public CostumerDTO execute(RegisterCostumerRequest request) {

        verifyIfCpfOrEmailAlreadyUsed(request);

        PersonalDetails personalDetails = createPersonalDetails.generatePersonalDetails(request);

        User user = User.createUser(request);

        saveUser.saveUser(user);

        Costumer costumer = Costumer.createCostumer(personalDetails, user);

        saveCostumer.saveCostumer(costumer);

        return CostumerDTO.of(costumer);
    }

    private void verifyIfCpfOrEmailAlreadyUsed(RegisterCostumerRequest request) {

        if(findCostumerByCpfOrEmail.costumerAlreadyRegistered(request.getCpf(), request.getEmail())){

            throw new BusinessRuleException("CPF or Email already used");
        }
    }
}
