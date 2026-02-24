package com.sena.test.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.test.Entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(String nombre);
}