package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.repositories.model.PackageType;
import com.appleindustries.challenge.service.CustomerOrderService;
import com.appleindustries.challenge.service.CustomerService;
import com.appleindustries.challenge.service.model.CustomerDTO;
import com.appleindustries.challenge.service.model.CustomerOrderRequestDTO;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @PostMapping
    public CustomerOrderResponseDTO save(@RequestBody CustomerOrderRequestDTO customerOrderRequest) {
        return customerOrderService.save(customerOrderRequest);
    }
}
