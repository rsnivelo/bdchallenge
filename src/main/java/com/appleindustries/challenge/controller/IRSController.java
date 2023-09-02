package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.service.OrderDetailService;
import com.appleindustries.challenge.service.model.CustomerDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/irs")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IRSController {

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping()
    public Double getTax(@RequestParam(name = "date") String dateParam) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateParam + " 00:00:00", formatter);

        return orderDetailService.getTax(parsedDateTime);

    }
}
