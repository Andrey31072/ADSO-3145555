package com.sena.test.controller.security;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.sena.test.entity.security.userRole;
import com.sena.test.service.security.IUserRoleService;

@RestController
@RequestMapping("/api/user-roles")
public class userRoleController {

    private final IUserRoleService service;
    public userRoleController(IUserRoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<userRole> getAll() {
        return service.findAll();
    }

    @PostMapping
    public userRole assignRole(@RequestBody userRole userRole) {
        return service.save(userRole);
    }
}
