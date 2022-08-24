package com.github.caio015.myonlineshop.costumer.application.port.out;

public interface VerifyIfEmailOrCpfIsAlreadyRegisteredPort {

    boolean costumerAlreadyRegistered(String cpf, String email);
}
