package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.service.CustomerService;
import com.appleindustries.challenge.service.MirrorService;
import com.appleindustries.challenge.service.model.CustomerDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public String save(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }
}
