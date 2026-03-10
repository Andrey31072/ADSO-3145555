package com.sena.test.entity.security;
import jakarta.persistence.*;

@Entity
@Table(name= "user_role")
@Getter
@Setter

public class userRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private role role;
}
