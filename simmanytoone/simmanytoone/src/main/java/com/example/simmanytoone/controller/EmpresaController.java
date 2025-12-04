package com.example.simmanytoone.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simmanytoone.entity.Empleados;
import com.example.simmanytoone.repository.EmpleadoRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {


    
    private final EmpleadoRepository empleadoRepository;

    public EmpresaController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // GET empleados por empresa
    @GetMapping("/{empresaId}/empleados")
    public List<Empleados> getEmpleadosByEmpresa(@PathVariable String empresaId) {
        return empleadoRepository.findByEmpresaId(empresaId);
    }

}
