package com.example.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.Rol;
import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Equipos;
import com.example.examen.service.ArbitrosService;

@RestController
@RequestMapping("/arbitros")
public class ArbitrosController {
    @Autowired
    private ArbitrosService arbitrosService;


    //Get
    @GetMapping
    public List<Arbitros> getAll(){
        return arbitrosService.findAll();
    }

    //Post
    @PostMapping
    public ResponseEntity<Arbitros> crate(@RequestBody Arbitros arbitro) {
        return ResponseEntity.ok(arbitrosService.save(arbitro));
    }


    //Get por rol
    @GetMapping("/{rol}")
    public List<Arbitros> getByRol(@PathVariable Rol rol){
        return arbitrosService.findByCondiciones(rol);
    }

    //Delete
    @DeleteMapping("/{uuid}")
        public ResponseEntity<Void> delete(@PathVariable String uuid) {
        if (!arbitrosService.existsById(uuid)) {
            return ResponseEntity.notFound().build();
        }
        arbitrosService.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
