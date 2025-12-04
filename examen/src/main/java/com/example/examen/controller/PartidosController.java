package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Jugadores;
import com.example.examen.entity.Partidos;
import com.example.examen.repository.EquiposRepository;
import com.example.examen.repository.JugadoresRepository;
import com.example.examen.repository.PartidosRepository;
import com.example.examen.service.ArbitrosService;
import com.example.examen.service.EquiposService;
import com.example.examen.service.PartidosService;

@RestController
@RequestMapping("/partidos")
public class PartidosController {

    private final PartidosRepository partidosRepository;
    private final EquiposRepository equiposRepository;
    private final JugadoresRepository jugadoresRepository;

        public PartidosController(JugadoresRepository jugadoresRepository, EquiposRepository equiposRepository,  PartidosRepository partidosRepository) {
        this.jugadoresRepository = jugadoresRepository;
        this.equiposRepository = equiposRepository;
        this.partidosRepository = partidosRepository;
    }

    private Partidos partido;

    @Autowired
    private EquiposService equiposService;
    private ArbitrosService arbitrosService;
    private PartidosService partidosService;



    //get con todos los parametros
    @PostMapping()
    public ResponseEntity<Partidos> postPartido(@RequestBody Partidos partido){

         return ResponseEntity.ok(partidosService.save(partido));
    }

    @PostMapping("/{e1id}/{e2id}/{arb1}/{arb2}")
     public ResponseEntity<Partidos> postPartidos(@PathVariable Long e1id, @PathVariable Long e2id, @PathVariable String arb1, @PathVariable String arb2){
        partido.setEquipo1(equiposRepository.getById(e1id));
        partido.setEquipo2(equiposRepository.getById(e2id));
       // partido.setArbitro1(arbitrosService.findById(arb2));
        return ResponseEntity.ok(partidosService.save(partido));
     }

}
