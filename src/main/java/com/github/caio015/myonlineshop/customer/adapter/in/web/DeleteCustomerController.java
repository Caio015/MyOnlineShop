package com.github.caio015.myonlineshop.customer.adapter.in.web;

import com.github.caio015.myonlineshop.customer.application.DeleteCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/myRegistration")
@RequiredArgsConstructor
public class DeleteCustomerController {

    private final DeleteCustomerUseCase useCase;

    @DeleteMapping(path = "/delete-customer/{customerId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long customerId){

        useCase.execute(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}
