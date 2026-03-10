package com.sena.test.service.security;
import java.util.List;
import com.sena.test.entity.security.role;

public interface IRoleService {
    List<role> findAll();
    role save(role role);
    void delete(Long id);
}

