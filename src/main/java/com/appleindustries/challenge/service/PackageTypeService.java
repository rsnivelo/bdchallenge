package com.appleindustries.challenge.service;

import com.appleindustries.challenge.service.model.CustomerDTO;
import com.appleindustries.challenge.service.model.PackageTypeDTO;

import java.util.List;

public interface PackageTypeService {

    List<PackageTypeDTO> getAll();

}
