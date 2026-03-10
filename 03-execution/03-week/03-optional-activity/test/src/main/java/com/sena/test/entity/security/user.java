package com.sena.test.entity.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
@Getter
@Setter
public class user extends person {
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private java.util.List<userRole> userRoles;
}
