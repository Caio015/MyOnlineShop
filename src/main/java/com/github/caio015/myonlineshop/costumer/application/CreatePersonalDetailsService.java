package com.github.caio015.myonlineshop.costumer.application;

import com.github.caio015.myonlineshop.costumer.domain.model.Address;
import com.github.caio015.myonlineshop.costumer.domain.model.PersonalDetails;
import com.github.caio015.myonlineshop.costumer.domain.model.PhoneNumber;
import com.github.caio015.myonlineshop.costumer.domain.request.RegisterCostumerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreatePersonalDetailsService {

    private final CostumerVerificationService costumerVerificationService;

    public PersonalDetails generatePersonalDetails(RegisterCostumerRequest request){

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
                                 .mainAddress(request.getMainAddress())
                                 .build();

        phoneNumbers(request).forEach(phoneNumber -> costumerVerificationService.verifyPhoneLenght(phoneNumber.getNumber()));

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

    private static List<PhoneNumber> phoneNumbers(RegisterCostumerRequest request) {

        return request.getPhoneNumber()
                      .stream()
                      .map(phoneRequest -> PhoneNumber.createPhoneNumber(phoneRequest.getPhoneNumber(),
                                                                         phoneRequest.getPrefix()))
                      .collect(Collectors.toList());
    }

}
