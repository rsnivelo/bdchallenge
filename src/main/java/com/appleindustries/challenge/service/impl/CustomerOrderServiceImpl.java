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
import com.appleindustries.challenge.service.mapper.CustomerOrderMapper;
import com.appleindustries.challenge.service.mapper.PackageTypeMapper;
import com.appleindustries.challenge.service.model.CustomerOrderRequestDTO;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;
import com.appleindustries.challenge.service.model.OrderDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    PackageTypeRepository packageTypeRepository;
    @Autowired
    Clock clock;

    @Autowired
    CustomerOrderMapper customerOrderMapper;
    @Autowired
    PackageTypeMapper packageTypeMapper;

    final static Double TAX_RATE = 0.08625;

    @Override
    public CustomerOrderResponseDTO save(CustomerOrderRequestDTO customerOrderRequestDTO) {

        Optional<Customer> customer = customerRepository.findById(customerOrderRequestDTO.getCustomerId());

        if (customer.isPresent()) {
            LocalDateTime creationTime = LocalDateTime.now(clock);
            CustomerOrder order = CustomerOrder.builder()
                    .creationDate(creationTime)
                    .total(customerOrderRequestDTO.getPackageType().getPrice())
                    .customer(customer.get())
                    .build();

            Optional<CustomerOrder> lastCustomerOrder = customerOrderRepository.findFirst1ByOrderByCreationDateDesc();
            order = customerOrderRepository.save(order);

            if (lastCustomerOrder.isPresent()) {
                if (lastCustomerOrder.get().getCreationDate().getHour() == creationTime.getHour()) {
                    OrderDetail orderDetail = OrderDetail.builder().packageType(packageTypeMapper.mapToEntity(customerOrderRequestDTO.getPackageType())).build();
                    return customerOrderMapper.mapToCustomerOrderResponse(order, Arrays.asList(customerOrderMapper.mapToOrderDetail(customerOrderRequestDTO.getPackageType(), orderDetailRepository.save(orderDetail).getId())));
                }
            }

            List<PackageType> packageTypes = packageTypeRepository.findAll();
            List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();

            for (PackageType packageType: packageTypes) {
                OrderDetail orderDetail = OrderDetail.builder().order(order).packageType(packageType).build();
                orderDetailDTOList.add(customerOrderMapper.mapToOrderDetail(packageType, orderDetailRepository.save(orderDetail).getId()));
            }

            return customerOrderMapper.mapToCustomerOrderResponse(order, orderDetailDTOList);
        } else {
            return new CustomerOrderResponseDTO();
        }
    }

    @Override
    public Double getTax(Integer year, Month month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.getMonth().length(start.isLeapYear()));

        List<CustomerOrder> payedOrders = customerOrderRepository.getPayedOrders(start, end);

        Double totalAmount = 0.0;
        for(CustomerOrder customerOrder: payedOrders) {
            totalAmount += customerOrder.getTotal();
        }

        return totalAmount * TAX_RATE;
    }


}
