package com.sena.test.service.impl;

import org.springframework.stereotype.Service;
import com.sena.test.entity.userRole;
import com.sena.test.repository.IroleRepository;
import java.util.List;
import com.sena.test.service.IuserRoleService;

@Service
public class RoleService implements IuserRoleService {

    private IroleRepository userRoleRepository;

    @Override
    public List<userRole> findAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public userRole saveUserRole(user userRole) {
        return userRoleRepository.save(userRole);
    }
}

