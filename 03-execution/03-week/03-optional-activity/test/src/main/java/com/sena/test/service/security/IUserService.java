package com.sena.test.service.security;
import java.util.List;
import com.sena.test.entity.security.user;

public interface IUserService {
    List<user> findAll();
    user findbyid(long id);
    user save(user user);
    void delete(Long id);
}
