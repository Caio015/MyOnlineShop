package com.github.caio015.myonlineshop.customer.adapter.out.persistence;

import com.github.caio015.myonlineshop.customer.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {

}
