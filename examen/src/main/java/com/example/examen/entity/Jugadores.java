package com.example.examen.entity;

import java.util.UUID;

import com.example.examen.Posicion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugadores {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipos equipo;

    private int dorsal;
    private String nombre;
    private String apellido1;
    private String apellido2;

    @Enumerated(EnumType.STRING)
    @Column(name = "posicion")
    private Posicion posicion;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Equipos getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    


}
