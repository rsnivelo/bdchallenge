package com.appleindustries.challenge.service;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.service.model.CustomerDTO;

public interface CustomerService {

    String save(CustomerDTO customer);

}
