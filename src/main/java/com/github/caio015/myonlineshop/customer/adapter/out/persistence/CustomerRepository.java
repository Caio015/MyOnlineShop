package com.github.caio015.myonlineshop.customer.adapter.out.persistence;

import com.github.caio015.myonlineshop.customer.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT COUNT (*) > 0 " +
           "FROM Customer c " +
           "JOIN User u ON u.id = c.user.id " +
           "WHERE c.personalDetails.cpf = :cpf " +
           "OR u.email = :email")
    Boolean verifyIfCpfAndEmailAlreadyRegistered(String cpf, String email);



}
