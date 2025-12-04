package com.example.simmanytoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simmanytoone.entity.Empleados;
import com.example.simmanytoone.entity.Empresas;
import com.example.simmanytoone.repository.EmpleadoRepository;
import com.example.simmanytoone.repository.EmpresaRepository;
import com.example.simmanytoone.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

    private final EmpleadoRepository empleadoRepository;
    private final EmpresaRepository empresaRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository, EmpresaRepository empresaRepository) {
        this.empleadoRepository = empleadoRepository;
        this.empresaRepository = empresaRepository;
    }

    // POST crear empleado asignado a empresa existente 
    @PostMapping("/{empresaId}")
    public ResponseEntity<Empleados> crearEmpleado(@PathVariable String empresaId,
            @RequestBody Empleados empleado) {

        Empresas empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        empleado.setEmpresa(empresa);
        return  ResponseEntity.ok(empleadoRepository.save(empleado));
    }

    // PUT actualizar edad
    @PutMapping("/{id}")
    public Empleados updateEdad(@PathVariable String id, @RequestBody int edad) {  //para el postman le das a json y pone el numero sin nada 

        Empleados empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setEdad(edad);
        return empleadoRepository.save(empleado);
    }

    // DELETE eliminar empleado
    @DeleteMapping("/{id}")
    public String eliminarEmpleado(@PathVariable String id) {

        empleadoRepository.deleteById(id);
        return "Empleado eliminado correctamente";
    }

}
