package com.github.caio015.myonlineshop.customer.adapter.in.web;

import com.github.caio015.myonlineshop.customer.application.EditCustomerDetailsUseCase;
import com.github.caio015.myonlineshop.customer.domain.dto.CustomerDTO;
import com.github.caio015.myonlineshop.customer.domain.request.EditCustomerDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/myRegistration")
@RequiredArgsConstructor
public class EditCustomerDetailsController {

    private final EditCustomerDetailsUseCase useCase;

    @PatchMapping("/edit-details/{customerId}")
    public ResponseEntity<CustomerDTO> editCustomer(@PathVariable Long customerId,
                                                    @RequestBody EditCustomerDetailsRequest request){

        CustomerDTO response = useCase.execute(customerId, request);

        return new ResponseEntity(response, HttpStatus.OK);

    }
}
