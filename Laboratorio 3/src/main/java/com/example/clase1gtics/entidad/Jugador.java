package com.example.clase1gtics.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "jugador")
@Getter
@Setter
public class Jugador {

    //Esto significa que es el Primary Key
    @Id
    //GeneratedValue significa que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJugador")
    private Integer idJugador;

    //nullable = false significa que es not null
    @Column(name = "nombre",nullable = false,length = 45)
    private String nombre;

    //nullable = false significa que es not null
    @Column(name = "edad",nullable = false)
    private Integer edad;

    //nullable = false significa que es not null
    @Column(name = "posicion",nullable = false,length = 45)
    private String posicion;

    //nullable = false significa que es not null
    @Column(name = "club",nullable = false,length = 45)
    private String club;

    //nullable = false significa que es not null
    @Column(name = "sn_idSeleccion",nullable = false)
    private Integer sn_idSeleccion;
}
