package com.sena.test.controller.bill;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.sena.test.entity.bill.billDetail;
import com.sena.test.service.bill.IBillDetailService;

@RestController
@RequestMapping("/api/bill-details")
public class billDetailController {
    private final IBillDetailService service;
    public billDetailController(IBillDetailService service) {
        this.service = service;
    }

    @GetMapping
    public List<billDetail> getAll() {
        return service.findAll();
    }

    @PostMapping
    public billDetail save(@RequestBody billDetail detail) {
        return service.save(detail);
    }
}
