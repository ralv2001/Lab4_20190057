package com.example.clase1gtics.repositorio;

import com.example.clase1gtics.entidad.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer>{
}
