package com.appleindustries.challenge.service;

import com.appleindustries.challenge.service.model.CustomerOrderRequestDTO;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public interface OrderDetailService {

    Double getTax(LocalDateTime date);

}
