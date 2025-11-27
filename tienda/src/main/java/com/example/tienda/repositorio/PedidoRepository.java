package com.example.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.model.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

    
} 
