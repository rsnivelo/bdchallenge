package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.service.CustomerService;
import com.appleindustries.challenge.service.PackageTypeService;
import com.appleindustries.challenge.service.model.CustomerDTO;
import com.appleindustries.challenge.service.model.PackageTypeDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/package-type")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PackageTypeController {

    @Autowired
    PackageTypeService packageTypeService;

    @GetMapping
    public List<PackageTypeDTO> getAll() {
        return packageTypeService.getAll();
    }
}
