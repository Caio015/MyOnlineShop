package com.github.caio015.myonlineshop.customer.domain.request;

import com.github.caio015.myonlineshop.customer.domain.model.Verifiable;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class EditCustomerDetailsRequest implements Verifiable {

    String firstName;

    String lastName;

    String cpf;

    LocalDate dateOfBirth;

    String avatarUrl;

    String streetName;

    String houseNumber;

    String apartmentNumber;

    String district;

    String cep;

    String city;

    String state;

    String country;

    List<PhoneNumberRequest> phoneNumber;

}
