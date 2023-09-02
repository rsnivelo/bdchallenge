package com.appleindustries.challenge.service.mapper;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.service.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "uuid", target = "id")
    Customer mapToEntity(CustomerDTO customerDTO, String uuid);

    Customer mapToEntity(CustomerDTO customerDTO);
}
