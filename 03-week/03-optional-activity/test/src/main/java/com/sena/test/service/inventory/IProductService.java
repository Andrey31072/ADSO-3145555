package com.sena.test.service.inventory;
import  java.util.List;
import com.sena.test.entity.inventory.product;

public interface IProductService {
    List<product> findAll();
    product save(product product);
    void delete(long id);
}
