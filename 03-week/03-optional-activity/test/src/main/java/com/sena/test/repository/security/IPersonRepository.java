package com.sena.test.repository.security;
import com.sena.test.entity.security.person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<person, Long> {

}
