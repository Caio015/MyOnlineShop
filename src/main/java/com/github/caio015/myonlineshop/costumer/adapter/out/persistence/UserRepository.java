package com.github.caio015.myonlineshop.costumer.adapter.out.persistence;

import com.github.caio015.myonlineshop.costumer.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {

}
