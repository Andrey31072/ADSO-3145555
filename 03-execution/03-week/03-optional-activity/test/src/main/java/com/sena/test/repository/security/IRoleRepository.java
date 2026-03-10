package com.sena.test.repository.security;
import com.sena.test.entity.security.role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<role, Long> {
}
