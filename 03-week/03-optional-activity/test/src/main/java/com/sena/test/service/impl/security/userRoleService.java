package com.sena.test.service.impl.security;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sena.test.entity.security.userRole;
import com.sena.test.repository.security.IUserRoleRepository;
import com.sena.test.service.security.IUserRoleService;

@Service
public class userRoleService implements IUserRoleService {

    private final IUserRoleRepository repository;

    public userRoleService(IUserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<userRole> findAll() {
        return repository.findAll();
    }

    @Override
    public userRole save(userRole userRole) {
        return repository.save(userRole);
    }
}
