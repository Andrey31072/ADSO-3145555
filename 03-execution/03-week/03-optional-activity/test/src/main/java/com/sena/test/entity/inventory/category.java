package com.sena.test.entity.inventory;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter

public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<product> products;

}
