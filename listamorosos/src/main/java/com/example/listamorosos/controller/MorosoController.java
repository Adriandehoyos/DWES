package com.example.listamorosos.controller;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.listamorosos.model.Moroso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class MorosoController {

    public LinkedList <Moroso> lista = new LinkedList<>();

    @GetMapping("/Principal")
    public LinkedList<Moroso> obtenerMorosos(){
        return lista;
    }

    @PostMapping("/id")
    public String agregarMoroso(@RequestBody Moroso newMoroso) {
        lista.add(newMoroso);
        return "Moroso agregado correctamente";
    }
    


}//
