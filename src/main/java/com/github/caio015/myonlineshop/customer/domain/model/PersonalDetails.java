package com.github.caio015.myonlineshop.customer.domain.model;

import com.github.caio015.myonlineshop.customer.domain.request.EditCustomerDetailsRequest;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.ElementCollection;
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

    @ElementCollection @Cascade(CascadeType.REMOVE)
    List<PhoneNumber> phoneNumber = new ArrayList<>();

    public void editPersonalDetails(EditCustomerDetailsRequest request){

        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.cpf = request.getCpf();
        this.dateOfBirth = request.getDateOfBirth();
        this.avatarUrl = request.getAvatarUrl();
        this.adress.streetName = request.getStreetName();
        this.adress.houseNumber = request.getHouseNumber();
        this.adress.apartmentNumber = request.getApartmentNumber();
        this.adress.district = request.getDistrict();
        this.adress.cep = request.getCep();
        this.adress.city = request.getCity();
        this.adress.state = request.getState();
        this.adress.country = request.getCountry();
        this.phoneNumber.forEach(number -> number.editPhoneNumber(request));

    }
}
