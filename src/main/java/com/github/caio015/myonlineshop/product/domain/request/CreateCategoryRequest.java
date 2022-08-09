package com.github.caio015.myonlineshop.product.domain.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class CreateCategoryRequest {

    String name;

    @JsonCreator
    public CreateCategoryRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

}
