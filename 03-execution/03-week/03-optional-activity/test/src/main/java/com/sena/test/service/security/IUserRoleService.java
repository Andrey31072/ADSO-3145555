package com.sena.test.service.security;

import java.util.List;
import com.sena.test.entity.security.userRole;

public interface IUserRoleService {
    List<userRole> findAll();
    userRole save(userRole userRole);
}
