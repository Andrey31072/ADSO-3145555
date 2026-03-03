package com.sena.test.controller.inventory;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.test.entity.inventory.product;
import com.sena.test.service.inventory.IProductService;



@RestController
@RequestMapping("/api/products")
public class productController {
    
    private final IProductService service;
    public productController(IProductService service) {
        this.service = service;
    }
    @GetMapping
    public List<product> getAll() {
        return service.findAll();
    }

    @PostMapping
    public product save(@RequestBody product product) {
        return service.save(product);
    }

    @PostMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
