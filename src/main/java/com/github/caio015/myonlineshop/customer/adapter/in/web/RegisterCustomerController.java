package com.github.caio015.myonlineshop.customer.adapter.in.web;

import com.github.caio015.myonlineshop.customer.application.RegisterCustomerUseCase;
import com.github.caio015.myonlineshop.customer.domain.dto.CustomerDTO;
import com.github.caio015.myonlineshop.customer.domain.request.RegisterCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/myshop")
@RequiredArgsConstructor
public class RegisterCustomerController {

    private final RegisterCustomerUseCase useCase;

    @PostMapping("/register-Customer")
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody RegisterCustomerRequest request){

        CustomerDTO result = useCase.execute(request);

        return  new ResponseEntity(result, HttpStatus.CREATED);
    }

}
