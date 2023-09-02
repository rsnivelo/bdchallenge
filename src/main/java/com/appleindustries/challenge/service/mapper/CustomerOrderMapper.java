package com.appleindustries.challenge.service.mapper;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.CustomerOrder;
import com.appleindustries.challenge.repositories.model.OrderDetail;
import com.appleindustries.challenge.repositories.model.PackageType;
import com.appleindustries.challenge.service.model.CustomerDTO;
import com.appleindustries.challenge.service.model.CustomerOrderResponseDTO;
import com.appleindustries.challenge.service.model.OrderDetailDTO;
import com.appleindustries.challenge.service.model.PackageTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

    @Mapping(target = "orderDetailList", source = "orderDetailDTOList")
    CustomerOrderResponseDTO mapToCustomerOrderResponse(CustomerOrder customerOrder, List<OrderDetailDTO> orderDetailDTOList);

    @Mapping(target = "id", source = "customerOrder.id")
    CustomerOrderResponseDTO mapToCustomerOrderResponse(CustomerOrder customerOrder, PackageTypeDTO packageType);

    OrderDetailDTO mapToOrderDetail(PackageType packageType, String id);

    OrderDetailDTO mapToOrderDetail(PackageTypeDTO packageType, String id);

}
