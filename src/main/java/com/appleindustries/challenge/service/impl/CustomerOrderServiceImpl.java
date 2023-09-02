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
import jakarta.persistence.criteria.Order;
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
            Optional<PackageType> packageType = packageTypeRepository.findById(customerOrderRequestDTO.getPackageId());
            LocalDateTime creationTime = LocalDateTime.now(clock);
            CustomerOrder order = CustomerOrder.builder()
                    .creationDate(creationTime)
                    .customer(customer.get())
                    .build();

            Optional<CustomerOrder> lastCustomerOrder = customerOrderRepository.findFirst1ByOrderByCreationDateDesc();
            order = customerOrderRepository.save(order);

            if (lastCustomerOrder.isPresent()) {
                if (lastCustomerOrder.get().getCreationDate().getHour() == creationTime.getHour()) {
                    OrderDetail orderDetail = OrderDetail.builder().order(order).packageType(packageType.get()).price(packageType.get().getPrice()).build();
                    return customerOrderMapper.mapToCustomerOrderResponse(order, Arrays.asList(customerOrderMapper.mapToOrderDetail(packageType.get(),
                            orderDetailRepository.save(orderDetail).getId())));
                }
            }

            List<PackageType> packageTypes = packageTypeRepository.findAll();
            List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();

            for (PackageType pkg: packageTypes) {
                OrderDetail orderDetail;
                if (pkg.getId().equals(customerOrderRequestDTO.getPackageId())) {
                    orderDetail = OrderDetail.builder().order(order).packageType(pkg).price(pkg.getPrice()).build();
                } else {
                    orderDetail = OrderDetail.builder().order(order).packageType(pkg).build();
                }
                orderDetailDTOList.add(customerOrderMapper.mapToOrderDetail(pkg, orderDetailRepository.save(orderDetail).getId()));
            }

            return customerOrderMapper.mapToCustomerOrderResponse(order, orderDetailDTOList);
        } else {
            return new CustomerOrderResponseDTO();
        }
    }

}
