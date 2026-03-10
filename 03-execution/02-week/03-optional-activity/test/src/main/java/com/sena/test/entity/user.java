package com.sena.test.entity;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")


public class user extends baseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private person person;

    @ManyToMany
    @JoinColumn(name = "role_id")
    private List<user> userRoles;
}
