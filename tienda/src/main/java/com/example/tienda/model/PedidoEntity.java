package com.example.tienda.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre_cliente;

    @Column(nullable = false)
    private LocalDateTime fecha_pedido;

    @Column(nullable = false)
    private Double importe_total;

    @Column(nullable = false)
    private String estado;


    


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre_cliente() {
        return nombre_cliente;
    }


    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }


    public LocalDateTime getFecha_pedido() {
        return fecha_pedido;
    }


    public void setFecha_pedido(LocalDateTime fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }


    public Double getImporte_total() {
        return importe_total;
    }


    public void setImporte_total(Double importe_total) {
        this.importe_total = importe_total;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    
}
