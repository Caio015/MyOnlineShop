package com.github.caio015.myonlineshop.costumer.adapter.out.persistence;

import com.github.caio015.myonlineshop.costumer.domain.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {

    @Query("SELECT COUNT (*) > 0 " +
           "FROM Costumer c " +
           "JOIN User u ON u.id = c.user.id " +
           "WHERE c.personalDetails.cpf = :cpf " +
           "OR u.email = :email")
    Boolean verifyIfCpfAndEmailAlreadyRegistered(String cpf, String email);



}
