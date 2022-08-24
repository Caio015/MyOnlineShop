package com.github.caio015.myonlineshop.costumer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Costumer {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long costumerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Embedded
    private PersonalDetails personalDetails;

    public Costumer(User user, PersonalDetails personalDetails) {

        this.user = user;
        this.personalDetails = personalDetails;
    }

    public static Costumer createCostumer(PersonalDetails personalDetails, User user) {

        return new Costumer(user, personalDetails);

    }

    public Address getCostumerAddress(){

        return this.getPersonalDetails().getAdress();
    }

    public List<PhoneNumber> getCostumerPhoneNumber(){

        return this.getPersonalDetails().getPhoneNumber();

    }

}
