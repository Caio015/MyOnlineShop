package com.github.caio015.myonlineshop.costumer.domain.model;

import com.github.caio015.myonlineshop.costumer.domain.request.RegisterCostumerRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user_login")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String email;

    @ToString.Exclude
    private String password;

    public User(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public static User createUser(RegisterCostumerRequest costumer){

        return new User(costumer.getEmail(), costumer.getPassword());
    }

}
