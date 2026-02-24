package com.sena.test.Service;

import java.util.List;

import com.sena.test.Entity.Rol;
import com.sena.test.dto.RolDto;

public interface IRolService {

    Rol create(RolDto dto);

    List<Rol> findAll();

    Rol findById(Long id);

    Rol update(Long id, RolDto dto);

    void delete(Long id);
}