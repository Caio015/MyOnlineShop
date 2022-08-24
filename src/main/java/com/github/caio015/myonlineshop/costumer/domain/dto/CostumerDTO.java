package com.github.caio015.myonlineshop.costumer.domain.dto;

import com.github.caio015.myonlineshop.costumer.domain.model.Address;
import com.github.caio015.myonlineshop.costumer.domain.model.Costumer;
import com.github.caio015.myonlineshop.costumer.domain.model.PhoneNumber;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class CostumerDTO {

     String firstName;

     String lastName;

     String cpf;

     LocalDate dateOfBirth;

     String avatarUrl;

     Address address;

     List<PhoneNumber> phoneNumber;

     public static CostumerDTO of(Costumer costumer) {

          return new CostumerDTO(
                  costumer.getPersonalDetails().getFirstName(),
                  costumer.getPersonalDetails().getLastName(),
                  costumer.getPersonalDetails().getCpf(),
                  costumer.getPersonalDetails().getDateOfBirth(),
                  costumer.getPersonalDetails().getAvatarUrl(),
                  costumer.getCostumerAddress(),
                  costumer.getCostumerPhoneNumber()

          );
     }
}
