package com.example.clase1gtics.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadio")
@Getter
@Setter
public class Estadio {

    //Esto significa que es el Primary Key
    @Id
    //GeneratedValue significa que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstadio")
    private Integer idEstadio;

    //nullable = false significa que es not null
    @Column(name = "nombre",nullable = false,length = 45)
    private String nombre;

    //nullable = false significa que es not null
    @Column(name = "provincia",nullable = false,length = 45)
    private String provincia;

    //nullable = false significa que es not null
    @Column(name = "club",length = 45)
    private String club;
}

