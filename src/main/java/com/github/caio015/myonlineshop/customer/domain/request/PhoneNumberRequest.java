package com.github.caio015.myonlineshop.customer.domain.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class PhoneNumberRequest {

    @NotNull @NotBlank String number;

    @NotNull @NotBlank String prefix;

}
