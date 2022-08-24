package com.github.caio015.myonlineshop.customer.domain.model;

import lombok.*;

import javax.persistence.Embedded;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {

    String firstName;

    String lastName;

    String cpf;

    LocalDate dateOfBirth;

    String avatarUrl;

    @Embedded
    Address adress;

    @Embedded
    List<PhoneNumber> phoneNumber = new ArrayList<>();

}
