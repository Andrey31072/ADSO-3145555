package com.sena.test.controller.security;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.test.entity.security.role;
import com.sena.test.service.security.IRoleService;

@RestController
@RequestMapping("/api/roles")
public class roleController {
    private final IRoleService service;
    public roleController(IRoleService service) {
        this.service = service;
    }
    @GetMapping
    public List<role> getAll() {
        return service.findAll();
    }
    @PostMapping
    public role save(@RequestBody role role) {
        return service.save(role);
    }
}
