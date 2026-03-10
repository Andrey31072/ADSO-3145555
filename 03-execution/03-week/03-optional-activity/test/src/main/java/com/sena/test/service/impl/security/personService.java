package com.sena.test.service.impl.security;


import org.springframework.stereotype.Service;
import java.util.List;

import com.sena.test.entity.security.user;
import com.sena.test.repository.security.IUserRepository;
import com.sena.test.service.security.IPersonService;

@Service
public class personService implements IPersonService {

    private final IUserRepository repository;

    public personService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<user> findAll() {
        return repository.findAll();
    }
}
