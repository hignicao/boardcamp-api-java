package com.boardcamp.api.repositories;

import com.boardcamp.api.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
  boolean existsByCpf(String cpf);
}
