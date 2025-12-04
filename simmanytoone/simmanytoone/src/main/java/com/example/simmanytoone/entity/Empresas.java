package com.example.simmanytoone.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresas {

@Id
    private String id = UUID.randomUUID().toString();

    private String nombre;

    @OneToMany(mappedBy = "empresa")
    private List<Empleados> empleados;


}
