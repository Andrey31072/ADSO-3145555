package com.sena.test.service.security;
import java.util.List;
import com.sena.test.entity.security.user;

public interface IPersonService {
    List<user> findAll();
}
