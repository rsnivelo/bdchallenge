package com.appleindustries.challenge.service.mapper;

import com.appleindustries.challenge.repositories.model.CustomerOrder;
import com.appleindustries.challenge.repositories.model.OrderDetail;
import com.appleindustries.challenge.repositories.model.PackageType;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;
import com.appleindustries.challenge.service.model.OrderDetailDTO;
import com.appleindustries.challenge.service.model.PackageTypeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetail mapToCustomerOrderResponse(PackageType packageType, String orderId);

//    CustomerOrderResponseDTO mapToCustomerOrderResponse(CustomerOrder customerOrder, PackageTypeDTO packageType);

}
