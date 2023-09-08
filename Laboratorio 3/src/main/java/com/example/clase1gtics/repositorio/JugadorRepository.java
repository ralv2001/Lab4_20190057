package com.example.clase1gtics.repositorio;

import com.example.clase1gtics.entidad.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer>{
}
