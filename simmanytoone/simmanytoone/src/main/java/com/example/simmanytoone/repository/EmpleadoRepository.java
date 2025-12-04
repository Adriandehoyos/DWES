package com.example.simmanytoone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simmanytoone.entity.Empleados;

public interface EmpleadoRepository extends JpaRepository<Empleados, String> {

        List<Empleados> findByEmpresaId(String empresaId);
}
