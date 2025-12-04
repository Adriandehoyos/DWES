package com.example.examen.service;

import org.springframework.stereotype.Service;

import com.example.examen.entity.Equipos;
import com.example.examen.entity.Partidos;
import com.example.examen.repository.EquiposRepository;
import com.example.examen.repository.JugadoresRepository;
import com.example.examen.repository.PartidosRepository;

@Service
public class PartidosService {
        private final PartidosRepository partidosRepository;


        public PartidosService(PartidosRepository partidosRepository) {
        this.partidosRepository = partidosRepository;
    }

    //Post
    public Partidos save(Partidos partido){
        return partidosRepository.save(partido);
    }
}
