package com.example.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Jugadores;

public interface JugadoresRepository extends JpaRepository<Jugadores, String>{
    List<Jugadores> findByEquipoId(Long equipoId);
    
}
