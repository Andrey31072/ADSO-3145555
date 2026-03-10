package com.sena.test.entity.bill;

import jakarta.persistence.*;
import com.sena.test.entity.inventory.product;

@Entity
@Table(name = "bill_details")
@Getter
@Setter
public class billDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private bill bill;
}
