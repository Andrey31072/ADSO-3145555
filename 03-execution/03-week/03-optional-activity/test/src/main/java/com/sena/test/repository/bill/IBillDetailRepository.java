package com.sena.test.repository.bill;
import com.sena.test.entity.bill.billDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillDetailRepository extends JpaRepository<billDetail, Long> {

}
