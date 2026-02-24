package com.sena.test.Service;

import com.sena.test.Entity.Person;



import com.sena.test.dto.PersonDto;
import com.sena.test.Entity.User;

import java.util.List;

public interface IPersonService {

    User create(PersonDto dto);

    List<User> findAll();

    User findById(Long id);

    User update(Long id, PersonDto dto);

    void delete(Long id);
}