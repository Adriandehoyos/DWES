package com.example.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Equipos;
import com.example.examen.entity.Jugadores;
import com.example.examen.entity.Partidos;

public interface PartidosRepository extends JpaRepository<Partidos, String>{
    
}
