package com.example.clase1gtics.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter

public class Countries {
    //Esto significa que es el Primary Key
    @Id
    @Column(name = "country_id")
    private String country_id;

    //nullable = false significa que es not null
    @Column(name = "country_name",length = 45)
    private String country_name;

    @Column(name = "region_id",length = 45)
    private Integer region_id;
}
