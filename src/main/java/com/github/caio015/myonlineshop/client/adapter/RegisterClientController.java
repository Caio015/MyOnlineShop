package com.github.caio015.myonlineshop.client.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "register-client")
@RequiredArgsConstructor
public class RegisterClientController {

    private final RegisterClientUseCase useCase;

}
