package com.sena.test.service.impl.bill;

import org.springframework.stereotype.Service;
import java.util.List;
import com.sena.test.entity.bill.bill;
import com.sena.test.repository.bill.IBillRepository;
import com.sena.test.service.bill.IBillService;



@Service
public class billService implements IBillService {

    private final IBillRepository repository;

    public billService(IBillRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<bill> findAll() {
        return repository.findAll();
    }

    @Override
    public bill save(bill bill) {
        return repository.save(bill);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
