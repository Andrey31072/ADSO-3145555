package com.sena.test.Service.Impl;


import com.sena.test.dto.PersonDto;
import com.sena.test.Entity.User;
import com.sena.test.Repository.IUserRepository;
import com.sena.test.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public User create(PersonDto dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        if (repository.findByIdentidad(dto.getIdentidad()).isPresent()) {
            throw new RuntimeException("La identidad ya está registrada");
        }

        User u = new User();
        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setIdentidad(dto.getIdentidad());

        return repository.save(u);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public User update(Long id, PersonDto dto) {

        User u = findById(id);

        u.setFirstName(dto.getFirstName());
        u.setLastName(dto.getLastName());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setIdentidad(dto.getIdentidad());

        return repository.save(u);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}