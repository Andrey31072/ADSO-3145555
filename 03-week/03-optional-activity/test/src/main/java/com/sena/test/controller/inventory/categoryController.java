package com.sena.test.controller.inventory;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.test.entity.inventory.category;
import com.sena.test.service.inventory.ICategoryService;


@RestController
@RequestMapping("/api/categories")
public class categoryController {
    private final ICategoryService service;
    public categoryController(ICategoryService service) {
        this.service = service;
    }
    @GetMapping
    public List<category> getAll() {
        return service.findAll();
    }
    @PostMapping
    public category save(@RequestBody category category) {
        return service.save(category);
    }
}
