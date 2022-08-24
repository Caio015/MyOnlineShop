package com.github.caio015.myonlineshop.costumer.domain.model;

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
}
