package com.example.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.entity.Jugadores;
import com.example.examen.repository.JugadoresRepository;

@Service
public class JugadoresService {
        private final JugadoresRepository jugadoresRepository;

    public JugadoresService(JugadoresRepository jugadoresRepository){
        this.jugadoresRepository = jugadoresRepository;
    }



    //Get all
    public List<Jugadores> findAll(){
        return jugadoresRepository.findAll();
    }

}
