package com.github.caio015.myonlineshop.costumer.application.port.out;

import com.github.caio015.myonlineshop.costumer.domain.model.User;

public interface SaveUserPort {

    void saveUser(User user);

}
