package com.example.clase1gtics.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter

public class Employees {
    //Esto significa que es el Primary Key
    @Id
    //GeneratedValue significa que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employee_id;

    //nullable = false significa que es not null
    @Column(name = "first_name",length = 45)
    private String first_name;

    //nullable = false significa que es not null
    @Column(name = "last_name",nullable = false,length = 45)
    private String last_name;

    //nullable = false significa que es not null
    @Column(name = "email",nullable = false,length = 45)
    private String email;

    //nullable = false significa que es not null
    @Column(name = "password",length = 45)
    private String password;

    //nullable = false significa que es not null
    @Column(name = "phone_number",length = 45)
    private String phone_number;

    //nullable = false significa que es not null
    @Column(name = "hire_date",length = 45)
    private Date hire_date;

    @Column(name = "job_id",nullable = false,length = 45)
    private String job_id;

    @Column(name = "salary",length = 45)
    private Integer salary;

    @Column(name = "commission_pct",length = 45)
    private Integer commission_pct;

    @Column(name = "manager_id",nullable = false,length = 45)
    private Integer manager_id;

    @Column(name = "department_id",nullable = false,length = 45)
    private Integer department_id;

    @Column(name = "enabled",length = 45)
    private Integer enabled;

}
