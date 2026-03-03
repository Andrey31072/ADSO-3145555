package com.sena.test.entity.bill;

import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "bills")
@Getter
@Setter

public class bill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    private Double total;

    @OneToMany(mappedBy="bill", cascade=CascadeType.ALL)
    private List<billDetail> bill_details;

}