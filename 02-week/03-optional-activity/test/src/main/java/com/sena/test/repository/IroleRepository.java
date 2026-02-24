package com.sena.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.test.entity.user;
import com.sena.test.entity.person;

public interface IroleRepository extends JpaRepository<user, Long> {

}
