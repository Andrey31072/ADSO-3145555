package com.sena.test.repository.inventory;
import com.sena.test.entity.inventory.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<product, Long> {
}
