package com.sena.test.controller.bill;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.sena.test.entity.bill.bill;
import com.sena.test.service.bill.IBillService;

@RestController
@RequestMapping("/api/bills")
public class billController {

    private final IBillService service;
    public billController(IBillService service) {
        this.service = service;
    }
    @GetMapping
    public List<bill> getAll() {
        return service.findAll();
    }

    @PostMapping
    public bill save(@RequestBody bill bill) {
        return service.save(bill);
    }
}
