package com.github.caio015.myonlineshop.customer.domain.model;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    String streetName;

    String houseNumber;

    String apartmentNumber;

    String district;

    String cep;

    String city;

    String state;

    String country;

    Boolean mainAddress;

}
