package com.example.examen.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Equipos;
import com.example.examen.entity.Jugadores;
import com.example.examen.repository.EquiposRepository;
import com.example.examen.repository.JugadoresRepository;
import com.example.examen.service.JugadoresService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/jugadores")
public class JugadoresController {

    private final EquiposRepository equiposRepository;
    private final JugadoresRepository jugadoresRepository;

        public JugadoresController(JugadoresRepository jugadoresRepository, EquiposRepository equiposRepository) {
        this.jugadoresRepository = jugadoresRepository;
        this.equiposRepository = equiposRepository;
    }

    @Autowired
    private JugadoresService jugadoresService;

    //Get all
    @GetMapping
    public List<Jugadores> getAll(){
        return this.jugadoresService.findAll();
    }

    //Get por equipo
    @GetMapping("/{equipo_id}")
    public ResponseEntity<List<Jugadores>> getByEquipo(@PathVariable Long equipo_id) {
        List<Jugadores> jugadores = jugadoresRepository.findByEquipoId(equipo_id);
        return ResponseEntity.ok(jugadores);
    }
    
    //Post
    @PostMapping("/{id}")
    public ResponseEntity<Jugadores> crearJugador(@PathVariable Long id, @RequestBody Jugadores jugador){
        //jugador.setId(null);
        Equipos equipo = equiposRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        jugador.setEquipo(equipo);
        return ResponseEntity.ok(jugadoresRepository.save(jugador));
    }

    //Put actualizar equipo
    @PutMapping("/{uuid}/{EquipoId}")
    public Jugadores updateEquipo(@PathVariable String uuid, @PathVariable Long EquipoId){
        Jugadores jugador = jugadoresRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        Equipos equipo = equiposRepository.findById(EquipoId).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        jugador.setEquipo(equipo);
        return jugadoresRepository.save(jugador);
    }









}
