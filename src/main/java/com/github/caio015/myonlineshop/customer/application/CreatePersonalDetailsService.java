package com.github.caio015.myonlineshop.customer.application;

import com.github.caio015.myonlineshop.customer.domain.model.Address;
import com.github.caio015.myonlineshop.customer.domain.model.PersonalDetails;
import com.github.caio015.myonlineshop.customer.domain.model.PhoneNumber;
import com.github.caio015.myonlineshop.customer.domain.request.RegisterCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreatePersonalDetailsService {

    private final CustomerVerificationService customerVerificationService;

    public PersonalDetails generatePersonalDetails(RegisterCustomerRequest request){

        LocalDate parsedDate = LocalDate.parse(request.getDateOfBirth(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Address address = Address.builder()
                                 .streetName(request.getStreetName())
                                 .houseNumber(request.getHouseNumber())
                                 .apartmentNumber(request.getApartmentNumber())
                                 .cep(request.getCep())
                                 .city(request.getCity())
                                 .state(request.getState())
                                 .district(request.getDistrict())
                                 .country(request.getCountry())
                                 .build();

        return   PersonalDetails.builder()
                                .firstName(request.getFirstName())
                                .lastName(request.getLastName())
                                .cpf(request.getCpf())
                                .avatarUrl(request.getAvatarUrl())
                                .dateOfBirth(parsedDate)
                                .adress(address)
                                .phoneNumber(phoneNumbers(request))
                                .build();


    }

    private static List<PhoneNumber> phoneNumbers(RegisterCustomerRequest request) {

        return request.getPhoneNumber()
                      .stream()
                      .map(phoneRequest -> PhoneNumber.createPhoneNumber(phoneRequest.getNumber(),
                                                                         phoneRequest.getPrefix()))
                      .collect(Collectors.toList());
    }

}
