package com.github.caio015.myonlineshop.customer.domain.dto;

import com.github.caio015.myonlineshop.customer.domain.model.Address;
import com.github.caio015.myonlineshop.customer.domain.model.Customer;
import com.github.caio015.myonlineshop.customer.domain.model.PhoneNumber;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class CustomerDTO {

     String firstName;

     String lastName;

     String cpf;

     LocalDate dateOfBirth;

     String avatarUrl;

     Address address;

     List<PhoneNumber> phoneNumber;

     public static CustomerDTO of(Customer customer) {

          return new CustomerDTO(
                  customer.getPersonalDetails().getFirstName(),
                  customer.getPersonalDetails().getLastName(),
                  customer.getPersonalDetails().getCpf(),
                  customer.getPersonalDetails().getDateOfBirth(),
                  customer.getPersonalDetails().getAvatarUrl(),
                  customer.getCustomerAddress(),
                  customer.getCustomerPhoneNumber()

          );
     }
}
