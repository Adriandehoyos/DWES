package com.example.listamorosos.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.listamorosos.model.Moroso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class MorosoController {

    public LinkedList <Moroso> lista = new LinkedList<>();

    @GetMapping("/api/morosos/principal")
    public LinkedList<Moroso> obtenerMorosos(){
        return lista;
    }

    @PostMapping("/api/morosos/add")
    public String agregarMorosos(@RequestBody List<Moroso> nuevosMorosos) {
        lista.addAll(nuevosMorosos);
        return "Morosos agregados correctamente";
    }
    
    @DeleteMapping("/api/morosos/eliminar/{id}")
    public void eliminarMoroso(@PathVariable int id) {
        lista.remove(id);
    }
    


}//
