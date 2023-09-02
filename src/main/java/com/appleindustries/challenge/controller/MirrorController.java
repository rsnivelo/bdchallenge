package com.appleindustries.challenge.controller;

import com.appleindustries.challenge.service.MirrorService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mirror")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MirrorController {

    @Autowired
    MirrorService mirrorService;

    @GetMapping("{message}")
    public String getReflectiveMessage (@PathVariable(name = "message") String message) {
        return mirrorService.getReflectiveMessage(message);
    }
}
