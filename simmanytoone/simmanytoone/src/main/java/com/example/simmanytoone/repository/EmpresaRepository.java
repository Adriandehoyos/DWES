package com.example.simmanytoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simmanytoone.entity.Empresas;
import java.util.List;


public interface EmpresaRepository extends JpaRepository<Empresas, String> {


}
