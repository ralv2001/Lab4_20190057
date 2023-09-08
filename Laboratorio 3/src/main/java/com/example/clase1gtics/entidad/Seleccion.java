package com.example.clase1gtics.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "seleccion")
@Getter
@Setter
public class Seleccion {

    //Esto significa que es el Primary Key
    @Id
    //GeneratedValue significa que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeleccion")
    private Integer idSeleccion;

    //nullable = false significa que es not null
    @Column(name = "nombre",nullable = false,length = 45)
    private String nombre;

    //nullable = false significa que es not null
    @Column(name = "tecnico",nullable = false,length = 45)
    private String tecnico;

    @Column(name = "estadio_idEstadio",nullable = false,length = 45)
    private Integer estadio_idEstadio;
}

