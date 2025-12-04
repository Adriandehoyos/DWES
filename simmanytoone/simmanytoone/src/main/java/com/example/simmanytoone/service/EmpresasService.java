package com.example.simmanytoone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.simmanytoone.entity.Empresas;
import com.example.simmanytoone.repository.EmpresaRepository;


@Service
public class EmpresasService {

    private final EmpresaRepository empresaRepository;

    public EmpresasService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    //metodo para el GET de todas las Empresas
    public List<Empresas> findAll(){
        return empresaRepository.findAll();
    }

    // //metodo para el GET de las empresas por su nombre
    // public List<Empresas> findByNombre(String nombre){
    //     return empresaRepository.findByEmpresaNombre(nombre);
    // }

    //metodo para el GET de las empresas por su id
        public Optional<Empresas> findByEmpresaId(String id){
        return empresaRepository.findById(id);
    }

}
