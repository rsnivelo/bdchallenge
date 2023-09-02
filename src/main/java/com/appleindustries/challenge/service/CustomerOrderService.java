package com.appleindustries.challenge.service;

import com.appleindustries.challenge.repositories.model.CustomerOrder;
import com.appleindustries.challenge.service.model.CustomerOrderRequestDTO;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

public interface CustomerOrderService {

    CustomerOrderResponseDTO save(CustomerOrderRequestDTO customerOrderRequestDTO);

}
