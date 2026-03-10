package com.sena.test.entity.inventory;

import java.text.DecimalFormat;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter

public class product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private category category;
}
