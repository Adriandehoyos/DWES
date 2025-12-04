package com.example.meteodaw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.meteodaw.entity.Ciudad;
import com.example.meteodaw.repository.CiudadRepository;

@Service
public class CiudadesService {
    
    private final CiudadRepository ciudadRepository;

    public CiudadesService(CiudadRepository ciudadRepository){
        this.ciudadRepository = ciudadRepository;
    }

    //GET /ciudades
    public List<Ciudad> findAll(){
        return ciudadRepository.findAll();
    }

    //GET /ciudades/{id}
    public Ciudad findById(Long id){
        return ciudadRepository.findById(id).orElse(null);
    }

    //POST /ciudades
    public Ciudad save(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }

}
