package com.boardcamp.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.CustomerDTO;
import com.boardcamp.api.exceptions.CustomerCPFConflictException;
import com.boardcamp.api.exceptions.CustomerNotFoundException;
import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.repositories.CustomerRepository;

@Service
public class CustomerService {

  final CustomerRepository customerRepository;

  CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerModel save(CustomerDTO customerDTO) {
    if (customerRepository.existsByCpf(customerDTO.getCpf())) {
      throw new CustomerCPFConflictException("Customer already exists");
    }

    CustomerModel customer = new CustomerModel(customerDTO);
    return customerRepository.save(customer);
  }

  public CustomerModel findById(Long id) {
    return customerRepository.findById(id).orElseThrow(
        () -> new CustomerNotFoundException("Customer not found"));
  }

}
