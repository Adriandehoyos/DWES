package com.example.examen.service;

import com.example.examen.entity.Equipos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.repository.EquiposRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquiposService {
    private final EquiposRepository equiposRepository;

    public EquiposService(EquiposRepository equiposRepository){
        this.equiposRepository = equiposRepository;
    }

    //Get all
    public List<Equipos> findAll(){
        return equiposRepository.findAll();
    }


    //Post
    public Equipos save(Equipos equipos){
        return equiposRepository.save(equipos);
    }

    //Put del nombre
    public Equipos updateNombre(Long id, String nombre_equipo){
        if(nombre_equipo == null){
            return null;
        }else{
            Equipos equipos = equiposRepository.findById(id).orElse(null);
            equipos.setNombre_equipo(nombre_equipo);
            return equiposRepository.save(equipos);
        }
    }

    //Delete
    //Primero para buscarlo
    public boolean existsById(Long id) {
    return equiposRepository.findById(id) != null;
    }
    //Ahora borrarlo
    public void deleteById(Long id) {
    if (equiposRepository.existsById(id)) {
        equiposRepository.deleteById(id);
    } else {
        throw new EntityNotFoundException("Equipo con id " + id + " no existe");
    }
    }






}
