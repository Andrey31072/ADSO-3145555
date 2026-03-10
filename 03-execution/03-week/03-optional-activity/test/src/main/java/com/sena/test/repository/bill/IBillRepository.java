package com.sena.test.repository.bill;
import com.sena.test.entity.bill.bill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBillRepository extends JpaRepository<bill, Long> {
}
