package com.sena.test.service.impl.bill;

import org.springframework.stereotype.Service;
import java.util.List;

import com.sena.test.entity.bill.billDetail;
import com.sena.test.repository.bill.IBillDetailRepository;
import com.sena.test.service.bill.IBillDetailService;

@Service
public class billDetailService implements IBillDetailService {

        private final IBillDetailRepository repository;

    public billDetailService(IBillDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<billDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public billDetail save(billDetail detail) {
        return repository.save(detail);
    }
}