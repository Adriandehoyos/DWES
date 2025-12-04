package com.example.meteodaw.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_meteorologicos")
public class DatosMeteorologicos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudad_id", nullable= false)
    private Ciudad ciudad;

    private LocalDate fecha;
    private Double temperatura;

    @Column(name = "sensacion_termica")
    private Double sensacionTermica;

    @Column(name = "probabilidad_lluvia")
    private Double probabilidadLluvia;

    private String descripcion;

    public DatosMeteorologicos() {
    }

    public DatosMeteorologicos(Long id, Ciudad ciudad, LocalDate fecha, Double temperatura, Double sensacionTermica,
            Double probabilidadLluvia, String descripcion) {
        this.id = id;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.temperatura = temperatura;
        this.sensacionTermica = sensacionTermica;
        this.probabilidadLluvia = probabilidadLluvia;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public double getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(Double sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public double getProbabilidadLluvia() {
        return probabilidadLluvia;
    }

    public void setProbabilidadLluvia(Double probabilidadLluvia) {
        this.probabilidadLluvia = probabilidadLluvia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
