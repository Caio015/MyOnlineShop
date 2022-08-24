package com.github.caio015.myonlineshop.costumer.domain.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Value
public class RegisterCostumerRequest {

    @NotNull @NotBlank String email;

    @NotNull @NotBlank String password;

    @NotNull @NotBlank String firstName;

    @NotNull @NotBlank String lastName;

    @NotNull @NotBlank String cpf;

    @NotNull @NotBlank String dateOfBirth;

    String avatarUrl;

    @NotNull @NotBlank String streetName;

    @NotNull @NotBlank String houseNumber;

    String apartmentNumber;

    @NotNull @NotBlank String district;

    @NotNull @NotBlank String cep;

    @NotNull @NotBlank String city;

    @NotNull @NotBlank String state;

    @NotNull @NotBlank String country;

    @NotNull @NotBlank Boolean mainAddress;

    List<PhoneNumberRequest> phoneNumber;

}
