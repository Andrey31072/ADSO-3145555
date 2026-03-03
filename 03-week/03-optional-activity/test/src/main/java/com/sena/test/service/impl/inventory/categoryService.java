package com.sena.test.service.impl.inventory;

import org.springframework.stereotype.Service;
import java.util.List;

import com.sena.test.entity.inventory.category;
import com.sena.test.repository.inventory.ICategoryRepository;
import com.sena.test.service.inventory.ICategoryService;

@Service
public class categoryService implements ICategoryService {

    private final ICategoryRepository repository;

    public categoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<category> findAll() {
        return repository.findAll();
    }

    @Override
    public category save(category category) {
        return repository.save(category);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
