package com.example.dataAccessWithJPA.repository;

import com.example.dataAccessWithJPA.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Long> {

    List<Client> findByLastName(String lastName); //criando um método de consulta no BD personalizado.
    Optional<Client> findById(Long id);
}
