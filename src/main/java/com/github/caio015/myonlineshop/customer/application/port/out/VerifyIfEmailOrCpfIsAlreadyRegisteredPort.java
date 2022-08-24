package com.github.caio015.myonlineshop.customer.application.port.out;

public interface VerifyIfEmailOrCpfIsAlreadyRegisteredPort {

    boolean customerAlreadyRegistered(String cpf, String email);
}
