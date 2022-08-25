package com.github.caio015.myonlineshop.customer.domain.model;

import com.github.caio015.myonlineshop.customer.domain.request.PhoneNumberRequest;

import java.util.List;

public interface Verifiable {

    String getCep();

    String getCpf();

    String getState();

    List<PhoneNumberRequest> getPhoneNumber();



}
