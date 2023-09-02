package com.appleindustries.challenge.service.impl;

import com.appleindustries.challenge.repositories.CustomerOrderRepository;
import com.appleindustries.challenge.repositories.CustomerRepository;
import com.appleindustries.challenge.repositories.OrderDetailRepository;
import com.appleindustries.challenge.repositories.PackageTypeRepository;
import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.CustomerOrder;
import com.appleindustries.challenge.repositories.model.OrderDetail;
import com.appleindustries.challenge.repositories.model.PackageType;
import com.appleindustries.challenge.service.CustomerOrderService;
import com.appleindustries.challenge.service.OrderDetailService;
import com.appleindustries.challenge.service.mapper.CustomerOrderMapper;
import com.appleindustries.challenge.service.mapper.PackageTypeMapper;
import com.appleindustries.challenge.service.model.CustomerOrderRequestDTO;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;
import com.appleindustries.challenge.service.model.OrderDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    final static Double TAX_RATE = 0.08625;

    @Override
    public Double getTax(LocalDateTime date) {

        LocalDateTime start = LocalDateTime.of(date.getYear(), date.getMonth(), 1, 0, 0);
        YearMonth baseMonth = YearMonth.from(start);
        LocalDateTime end = baseMonth.atEndOfMonth().atTime(23, 59, 59);

        List<OrderDetail> payedOrders = orderDetailRepository.getPayedOrders(start, end);

        Double totalAmount = 0.0;
        for(OrderDetail customerOrder: payedOrders) {
            totalAmount += customerOrder.getPrice();
        }

        return new BigDecimal(totalAmount * TAX_RATE).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


}
