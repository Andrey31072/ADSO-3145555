package com.sena.test.service.impl.inventory;
import  java.util.List;
import org.springframework.stereotype.Service;
import com.sena.test.repository.inventory.IProductRepository;
import com.sena.test.service.inventory.IProductService;

@Service
public class productService implements IProductService {

    private final IProductRepository repository;

    public productService(IProductRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<com.sena.test.entity.inventory.product> findAll() {
        return repository.findAll();
    }

    @Override
    public com.sena.test.entity.inventory.product save(com.sena.test.entity.inventory.product product) {
        return repository.save(product);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
