package com.appleindustries.challenge.service.mapper;

import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.PackageType;
import com.appleindustries.challenge.service.model.CustomerDTO;
import com.appleindustries.challenge.service.model.PackageTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PackageTypeMapper {
    List<PackageTypeDTO> mapToDto(List<PackageType> packageType);
    PackageType mapToEntity(PackageTypeDTO packageTypeDTO);

}
