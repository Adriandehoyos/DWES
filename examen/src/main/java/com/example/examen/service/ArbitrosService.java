package com.example.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.Rol;
import com.example.examen.entity.Arbitros;
import com.example.examen.repository.ArbitrosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ArbitrosService {
    
    private final ArbitrosRepository arbitrosRepository;

    public ArbitrosService(ArbitrosRepository arbitrosRepository){
        this.arbitrosRepository = arbitrosRepository;
    }

    //Get all
    public List<Arbitros> findAll(){
        return arbitrosRepository.findAll();
    }

    //Post
    public Arbitros save(Arbitros arbitro){
        return arbitrosRepository.save(arbitro);
    }

    //Get por rol
        public List <Arbitros> findByCondiciones(Rol rol){
        return arbitrosRepository.findByRol(rol);
    }
    //Get por id  para partidos
   // public List <Arbitros> findById(String id){
        //return arbitrosRepository.
    //}

    //delete
    //Primero para buscarlo
    public boolean existsById(String uuid) {
    return arbitrosRepository.findById(uuid) != null;
    }
    //Ahora borrarlo
    public void deleteById(String uuid) {
    if (arbitrosRepository.existsById(uuid)) {
        arbitrosRepository.deleteById(uuid);
    } else {
        throw new EntityNotFoundException("Arbitro con uuid: " + uuid + " no existe");
    }
    }

}
