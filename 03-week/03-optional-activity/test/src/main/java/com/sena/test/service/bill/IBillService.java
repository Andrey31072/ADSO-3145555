package com.sena.test.service.bill;
import java.util.List;
import com.sena.test.entity.bill.bill;

public interface IBillService {
    List<bill> findAll();
    bill save(bill bill);
    void delete(long id);
}
