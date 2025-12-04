package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Equipos;
import com.example.examen.service.EquiposService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/equipos")
public class EquipoController {
    @Autowired
    private EquiposService equiposService;

    //Get
    @GetMapping
    public List<Equipos> getAll(){
        return equiposService.findAll();
    }


    //Post
    @PostMapping
    public ResponseEntity<Equipos> crate(@RequestBody Equipos equipo) {
        equipo.setId(null);//el id es autoincremental
        return ResponseEntity.ok(equiposService.save(equipo));
    }

    //Put
    @PutMapping("/{id}/{nombre_equipo}")
    public ResponseEntity<Equipos> updateNombre( @PathVariable Long id, @PathVariable String nombre_equipo){
        Equipos actualizado = equiposService.updateNombre(id, nombre_equipo);
        if (actualizado == null) {
            // Puede ser porque no existe o porque el estado es inválido
            return ResponseEntity.badRequest().build();
        }
 
        return ResponseEntity.ok(actualizado);
    }

    //Delete
    @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!equiposService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        equiposService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
