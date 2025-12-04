package com.example.meteodaw.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meteodaw.entity.Ciudad;
import com.example.meteodaw.service.CiudadesService;




@RestController
@RequestMapping("/ciudades")
public class CiudadController {
    
    private final CiudadesService ciudadesService;

    public CiudadController(CiudadesService ciudadesService){
        this.ciudadesService = ciudadesService;
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> getAll(){
        return ResponseEntity.ok(ciudadesService.findAll());
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> getById(@PathVariable Long id) {
        Ciudad ciudad = ciudadesService.findById(id);
        if(ciudad != null){
            return ResponseEntity.ok(ciudad);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Ciudad> crearCiudad(@RequestBody Ciudad ciudad) {
        //TODO: process POST request
        return ResponseEntity.ok(ciudadesService.save(ciudad));
    }
    
    
}
