package com.example.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.Rol;
import com.example.examen.entity.Arbitros;

public interface ArbitrosRepository extends JpaRepository<Arbitros, String>{
    List<Arbitros> findByRol(Rol rol);
    //List<Arbitros> findById(String id);
}
