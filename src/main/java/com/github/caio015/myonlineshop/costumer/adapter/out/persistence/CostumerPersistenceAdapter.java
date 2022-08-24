package com.github.caio015.myonlineshop.costumer.adapter.out.persistence;

import com.github.caio015.myonlineshop.costumer.application.port.out.SaveCostumerPort;
import com.github.caio015.myonlineshop.costumer.application.port.out.VerifyIfEmailOrCpfIsAlreadyRegisteredPort;
import com.github.caio015.myonlineshop.costumer.domain.model.Costumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostumerPersistenceAdapter implements SaveCostumerPort,
                                                   VerifyIfEmailOrCpfIsAlreadyRegisteredPort {

    private final CostumerRepository repository;

    @Override
    public void saveCostumer(Costumer costumer) {

        repository.save(costumer);
    }

    @Override
    public boolean costumerAlreadyRegistered(String cpf, String email) {

        return repository.verifyIfCpfAndEmailAlreadyRegistered(cpf, email);
    }
}
