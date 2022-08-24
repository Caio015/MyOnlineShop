package com.github.caio015.myonlineshop.costumer.adapter.in.web;

import com.github.caio015.myonlineshop.costumer.application.RegisterCostumerUseCase;
import com.github.caio015.myonlineshop.costumer.domain.dto.CostumerDTO;
import com.github.caio015.myonlineshop.costumer.domain.request.RegisterCostumerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/myshop")
@RequiredArgsConstructor
public class RegisterCostumerController {

    private final RegisterCostumerUseCase useCase;

    @PostMapping("/register-costumer")
    public ResponseEntity<CostumerDTO> registerCostumer(@RequestBody RegisterCostumerRequest request){

        CostumerDTO result = useCase.execute(request);

        return  new ResponseEntity(result, HttpStatus.CREATED);
    }

}
