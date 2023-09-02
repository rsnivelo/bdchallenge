package com.appleindustries.challenge.service.impl;

import com.appleindustries.challenge.repositories.CustomerRepository;
import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.service.CustomerService;
import com.appleindustries.challenge.service.mapper.CustomerMapper;
import com.appleindustries.challenge.service.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public String save(CustomerDTO customer) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
        if (existingCustomer.isPresent()) {
            Customer customerToSave = customerMapper.mapToEntity(customer, existingCustomer.get().getId());
            return customerRepository.save(customerToSave).getId();
        }
        return customerRepository.save(customerMapper.mapToEntity(customer)).getId();
    }
}
