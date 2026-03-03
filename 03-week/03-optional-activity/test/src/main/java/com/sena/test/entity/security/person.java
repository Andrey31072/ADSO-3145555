package com.sena.test.entity.security;

import jakarta.persistence.*;
@MappedSuperclass
@Getter
@Setter

public abstract class person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String firstname;

    @Column(nullable= false)
    private String lastname;

    @Column(nullable= false)
    private String email;

    @Column(nullable= false)
    private String identification;

    private String phone;
}
