package com.sena.test.repository.security;
import com.sena.test.entity.security.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<user, Long> {
}
