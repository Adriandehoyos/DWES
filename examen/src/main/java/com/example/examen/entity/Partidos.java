package com.example.examen.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "partidos")
public class Partidos {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "equipo1_id")
    private Equipos equipo1;

    @ManyToOne
    @JoinColumn(name = "equipo2_id")
    private Equipos equipo2;

    @ManyToOne
    @JoinColumn(name = "arbitro1_id")
    private Arbitros arbitro1;

    @ManyToOne
    @JoinColumn(name = "arbitro2_id")
    private Arbitros arbitro2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Equipos getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipos equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipos getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipos equipo2) {
        this.equipo2 = equipo2;
    }

    public Arbitros getArbitro1() {
        return arbitro1;
    }

    public void setArbitro1(Arbitros arbitro1) {
        this.arbitro1 = arbitro1;
    }

    public Arbitros getArbitro2() {
        return arbitro2;
    }

    public void setArbitro2(Arbitros arbitro2) {
        this.arbitro2 = arbitro2;
    }

    


}
