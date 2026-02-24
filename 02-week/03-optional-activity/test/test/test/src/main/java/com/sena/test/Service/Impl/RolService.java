package com.sena.test.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.test.Entity.Rol;
import com.sena.test.Repository.IRolRepository;
import com.sena.test.Service.IRolService;
import com.sena.test.dto.RolDto;


@Service
public class RolService implements IRolService {

    @Autowired
    private IRolRepository repository;

    @Override
    public Rol create(RolDto dto) {

        if (repository.findByNombre(dto.getNombre()).isPresent()) {
            throw new RuntimeException("El rol ya existe");
        }

        Rol rol = new Rol();
        rol.setNombre(dto.getNombre());

        return repository.save(rol);
    }

    @Override
    public List<Rol> findAll() {
        return repository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    @Override
    public Rol update(Long id, RolDto dto) {

        Rol rol = findById(id);
        rol.setNombre(dto.getNombre());

        return repository.save(rol);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}