package com.sena.test.service.impl.security;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sena.test.entity.security.user;
import com.sena.test.repository.security.IUserRepository;
import com.sena.test.service.security.IUserService;

@Service
public class roleService implements IUserService {
    
        private final IUserRepository repository = null;

    public List<user> findAll() {
        return repository.findAll();
    }

    public user findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public user save(user user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public user findbyid(long id) {
        throw new UnsupportedOperationException("No se ha implementado el método findbyid en roleService");
    }

}
