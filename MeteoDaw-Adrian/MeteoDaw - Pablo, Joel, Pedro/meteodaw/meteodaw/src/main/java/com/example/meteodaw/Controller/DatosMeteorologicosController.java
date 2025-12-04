package com.example.meteodaw.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meteodaw.entity.Ciudad;
import com.example.meteodaw.entity.DatosMeteorologicos;
import com.example.meteodaw.repository.CiudadRepository;
import com.example.meteodaw.repository.DatosMeteorologicosRepository;

@RestController
@RequestMapping("/api")
public class DatosMeteorologicosController {
    
    private final CiudadRepository ciudadRepository;
    private final DatosMeteorologicosRepository datosMeteorologicosRepository;

    public DatosMeteorologicosController(CiudadRepository ciudadRepository, 
    DatosMeteorologicosRepository datosMeteorologicosRepository){
        this.ciudadRepository = ciudadRepository;
        this.datosMeteorologicosRepository = datosMeteorologicosRepository;
    }

    //GET datos de un pais por ID de pais
    //Ejemplo: GET /api/ciudades/1/datosmeteorologicos
    @GetMapping("/ciudades/{ciudadId}/datosmeteorologicos")
    public ResponseEntity<List<DatosMeteorologicos>> getDatosPorCiudad(@PathVariable Long ciudadId) {
        
        if(!ciudadRepository.existsById(ciudadId)){
            return ResponseEntity.notFound().build();
        }

        List<DatosMeteorologicos> datosMeteorologicos = datosMeteorologicosRepository.findByCiudadId(ciudadId);
        return ResponseEntity.ok(datosMeteorologicos);
    }

    //GET dato por ID de dato
    //Ejemplo: GET /api/datosmeteorologicos/1
    @GetMapping("/datosmeteorologicos/{id}")
    public ResponseEntity getDatosPorId(@PathVariable Long id) {
        return datosMeteorologicosRepository.findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/datosmeteorologicos")
    public ResponseEntity<DatosMeteorologicos> crearDato(@RequestBody DatosMeteorologicos datosMeteorologicos) {
        //TODO: process POST request
        if (datosMeteorologicos.getCiudad() == null || datosMeteorologicos.getCiudad().getId() == null){
            return ResponseEntity.badRequest().build();
        }

        Long ciudadId = datosMeteorologicos.getCiudad().getId();

        Ciudad ciudad = ciudadRepository.findById(ciudadId).orElse(null);
        
        if (ciudad == null){
            return ResponseEntity.badRequest().build();
        }

        datosMeteorologicos.setCiudad(ciudad);

        DatosMeteorologicos datoGuardado = datosMeteorologicosRepository.save(datosMeteorologicos);

        URI location = URI.create("/api/datosmeteorologicos" + datoGuardado.getId());
        return ResponseEntity.created(location).body(datoGuardado);
    }

    @DeleteMapping("/datosmeteorologicos/{id}")
    public ResponseEntity<Void> borrarDato(@PathVariable Long id) {

    if (!datosMeteorologicosRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    datosMeteorologicosRepository.deleteById(id);
    return ResponseEntity.noContent().build(); // 204
    }

    //Put temperatura
    @PutMapping("/datosmeteorologicos/{id}/temperatura")
    public ResponseEntity<DatosMeteorologicos> actualizarTemperatura(
        @PathVariable Long id,
        @RequestBody Double nuevaTemperatura) {

    return datosMeteorologicosRepository.findById(id)
        .map(dato -> {
            dato.setTemperatura(nuevaTemperatura);
            return ResponseEntity.ok(datosMeteorologicosRepository.save(dato));
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //put probabilidad
    @PutMapping("/datosmeteorologicos/{id}/probabilidadlluvia")
    public ResponseEntity<DatosMeteorologicos> actualizarProbabilidad(
        @PathVariable Long id,
        @RequestBody Double nuevaProbabilidad) {

    return datosMeteorologicosRepository.findById(id)
        .map(dato -> {
            dato.setProbabilidadLluvia(nuevaProbabilidad);
            return ResponseEntity.ok(datosMeteorologicosRepository.save(dato));
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
