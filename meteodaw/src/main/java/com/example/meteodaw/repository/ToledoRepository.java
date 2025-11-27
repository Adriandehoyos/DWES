package com.example.meteodaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.meteodaw.entity.Toledo;

@Repository
public interface ToledoRepository extends JpaRepository<Toledo, Long>{

    
} 