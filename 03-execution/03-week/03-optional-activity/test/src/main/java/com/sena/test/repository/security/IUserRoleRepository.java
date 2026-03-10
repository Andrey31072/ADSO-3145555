package com.sena.test.repository.security;
import com.sena.test.entity.security.userRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<userRole, Long> {

}
