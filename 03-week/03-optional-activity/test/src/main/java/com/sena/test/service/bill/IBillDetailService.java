package com.sena.test.service.bill;
import java.util.List;
import com.sena.test.entity.bill.billDetail;

public interface IBillDetailService {
    List<billDetail> findAll();
    billDetail save(billDetail billDetail);
}
