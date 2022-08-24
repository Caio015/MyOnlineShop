package com.github.caio015.myonlineshop.costumer.domain.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class PhoneNumberRequest {

    @NotNull @NotBlank String phoneNumber;

    @NotNull @NotBlank String prefix;

}
