package com.example.meteodaw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meteodaw.entity.DatosMeteorologicos;


public interface DatosMeteorologicosRepository extends JpaRepository<DatosMeteorologicos, Long> {
    
    List<DatosMeteorologicos> findByCiudadId(Long ciudadId);
    
}
