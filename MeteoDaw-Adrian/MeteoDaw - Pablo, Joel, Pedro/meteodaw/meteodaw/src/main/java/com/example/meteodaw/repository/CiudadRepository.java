package com.example.meteodaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meteodaw.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    
}
