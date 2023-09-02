package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.service.model.CustomerDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/irs")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IRSController {

    @GetMapping
    public String getTax(@RequestBody CustomerDTO customerDTO) {
//        return customerService.save(customerDTO);
        return null;
    }
}
