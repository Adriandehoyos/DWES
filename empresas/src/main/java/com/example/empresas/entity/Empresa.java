package com.example.empresas.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {


    @Id
    private String id = UUID.randomUUID().toString();

    private String nombre;   // "Nombre de empresa"

    public Empresa() {
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

