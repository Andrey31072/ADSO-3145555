package com.sena.test.controller.security;


import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.sena.test.entity.security.user;
import com.sena.test.service.security.IPersonService;

@RestController
@RequestMapping("/api/persons")
public class personController {

    private final IPersonService service;
    public personController(IPersonService service) {
        this.service = service;
    }
    @GetMapping
    public List<user> getAllPersons() {
        return service.findAll();
    }
}
