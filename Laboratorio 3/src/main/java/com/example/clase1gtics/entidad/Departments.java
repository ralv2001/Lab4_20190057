package com.example.clase1gtics.entidad;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departments")
@Getter
@Setter

public class Departments {

    //Esto significa que es el Primary Key
    @Id
    @Column(name = "department_id")
    private Integer department_id;

    //nullable = false significa que es not null
    @Column(name = "department_name",length = 45)
    private String department_name;

    //nullable = false significa que es not null
    @Column(name = "manager_id",length = 45)
    private String manager_id;

    //nullable = false significa que es not null
    @Column(name = "location_id",length = 45)
    private String location_id;

}


