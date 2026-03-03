package com.sena.test.service.inventory;
import java.util.List;
import com.sena.test.entity.inventory.category;

public interface ICategoryService {
    List<category> findAll();
    category save(category category);
    void delete(long id);
}
