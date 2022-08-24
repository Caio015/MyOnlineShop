package com.github.caio015.myonlineshop.costumer.adapter.out.persistence;

import com.github.caio015.myonlineshop.costumer.application.port.out.SaveUserPort;
import com.github.caio015.myonlineshop.costumer.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserPort {

    private final UserRepository repository;

    @Override
    public void saveUser(User user) {

        repository.save(user);

    }
}
