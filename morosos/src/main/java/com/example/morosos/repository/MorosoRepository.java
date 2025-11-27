package com.example.morosos.repository;

import com.example.morosos.entity.Moroso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MorosoRepository extends JpaRepository<Moroso, Long> {
}

