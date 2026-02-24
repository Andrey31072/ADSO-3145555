package com.sena.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.test.entity.user;

public interface IUserRepository extends JpaRepository<user, Long> {

}
