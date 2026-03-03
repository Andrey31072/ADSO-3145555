package com.sena.test.controller.security;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.test.entity.security.user;
import com.sena.test.service.security.IUserService;

@RestController
@RequestMapping("/api/users")
public class userController {
    private final IUserService service;
    public userController(IUserService service){
        this.service = service;
    }
    @GetMapping
    public List<user> getAll() {
        return service.findAll();
    }
    @PostMapping
    public user save(@RequestBody user user) {
        return service.save(user);
    }
}
