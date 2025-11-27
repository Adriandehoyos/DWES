package com.example.morosos.entity;

import java.time.LocalDate;

import com.example.morosos.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moroso")
public class Moroso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;

    @Column(name = "cantidad_adeudada")
    private Double deuda;

    @Column(name = "fecha_alta")
    private LocalDate fechaA;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pago")
    private Estado estadoP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getDeuda() {
        return deuda;
    }

    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }

    public LocalDate getFechaA() {
        return fechaA;
    }

    public void setFechaA(LocalDate fechaA) {
        this.fechaA = fechaA;
    }

    public Estado getEstadoP() {
        return estadoP;
    }

    public void setEstadoP(Estado estadoP) {
        this.estadoP = estadoP;
    }



    





}
