package com.sena.test.Service.Impl;

import com.sena.test.dto.PersonDto;
import com.sena.test.Entity.User;
import com.sena.test.Repository.IUserRepository;
import com.sena.test.Service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

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

        User p = new User();
        p.setFirstName(dto.getFirstName());
        p.setLastName(dto.getLastName());
        p.setEmail(dto.getEmail());
        p.setPassword(dto.getPassword());
        p.setIdentidad(dto.getIdentidad());

        return repository.save(p);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    public User update(Long id, PersonDto dto) {

        User p = findById(id);

        p.setFirstName(dto.getFirstName());
        p.setLastName(dto.getLastName());
        p.setEmail(dto.getEmail());
        p.setPassword(dto.getPassword());
        p.setIdentidad(dto.getIdentidad());

        return repository.save(p);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}