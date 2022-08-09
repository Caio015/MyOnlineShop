package com.github.caio015.myonlineshop.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public Category(String name) {

        this.name = name;
    }
}
