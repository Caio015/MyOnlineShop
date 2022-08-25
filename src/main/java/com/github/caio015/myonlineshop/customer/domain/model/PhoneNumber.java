package com.github.caio015.myonlineshop.customer.domain.model;

import com.github.caio015.myonlineshop.customer.domain.request.EditCustomerDetailsRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {

    private String number;

    private String prefix;

    public static PhoneNumber createPhoneNumber(String phoneNumber, String prefix){

        return new PhoneNumber(phoneNumber,
                               prefix);
    }

    public void editPhoneNumber(EditCustomerDetailsRequest request) {

        request.getPhoneNumber()
               .forEach(phoneRequest -> {

                   this.number = phoneRequest.getNumber();
                   this.prefix = phoneRequest.getPrefix();

               });
    }
}
