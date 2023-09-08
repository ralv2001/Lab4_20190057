package com.example.clase1gtics.repositorio;

import com.example.clase1gtics.entidad.Seleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
}
