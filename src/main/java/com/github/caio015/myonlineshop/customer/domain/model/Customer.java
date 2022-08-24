package com.github.caio015.myonlineshop.customer.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Embedded
    private PersonalDetails personalDetails;

    public Customer(User user, PersonalDetails personalDetails) {

        this.user = user;
        this.personalDetails = personalDetails;
    }

    public static Customer createCustomer(PersonalDetails personalDetails, User user) {

        return new Customer(user, personalDetails);

    }

    public Address getCustomerAddress(){

        return this.getPersonalDetails().getAdress();
    }

    public List<PhoneNumber> getCustomerPhoneNumber(){

        return this.getPersonalDetails().getPhoneNumber();

    }

}
