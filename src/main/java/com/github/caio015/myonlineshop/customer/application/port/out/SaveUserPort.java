package com.github.caio015.myonlineshop.customer.application.port.out;

import com.github.caio015.myonlineshop.customer.domain.model.User;

public interface SaveUserPort {

    void saveUser(User user);

}
