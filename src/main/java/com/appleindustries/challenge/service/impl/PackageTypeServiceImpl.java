package com.appleindustries.challenge.service.impl;

import com.appleindustries.challenge.repositories.CustomerRepository;
import com.appleindustries.challenge.repositories.PackageTypeRepository;
import com.appleindustries.challenge.repositories.model.Customer;
import com.appleindustries.challenge.repositories.model.PackageType;
import com.appleindustries.challenge.service.CustomerService;
import com.appleindustries.challenge.service.PackageTypeService;
import com.appleindustries.challenge.service.mapper.CustomerMapper;
import com.appleindustries.challenge.service.mapper.PackageTypeMapper;
import com.appleindustries.challenge.service.model.CustomerDTO;
import com.appleindustries.challenge.service.model.PackageTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PackageTypeServiceImpl implements PackageTypeService {

    @Autowired
    PackageTypeRepository packageTypeRepository;

    @Autowired
    PackageTypeMapper packageTypeMapper;

    @Override
    public List<PackageTypeDTO> getAll() {
        return packageTypeMapper.mapToDto(packageTypeRepository.findAll());
    }
}
