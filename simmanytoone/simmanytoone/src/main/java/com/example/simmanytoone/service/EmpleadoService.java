package com.example.simmanytoone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simmanytoone.entity.Empleados;
import com.example.simmanytoone.repository.EmpleadoRepository;
import com.example.simmanytoone.repository.EmpresaRepository;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;


private final EmpresaRepository empresaRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository, EmpresaRepository empresaRepository) {
        this.empleadoRepository = empleadoRepository;
        this.empresaRepository = empresaRepository;
    }



    public List<Empleados> findAll(){
        return empleadoRepository.findAll();
    }


    public List<Empleados> encontrarPorIdEmpresa(String empresaId){

        return empleadoRepository.findByEmpresaId(empresaId);
    }

    
        public Empleados save(Empleados empleado) {
        return empleadoRepository.save(empleado);
    }




}
