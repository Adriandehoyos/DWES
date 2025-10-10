package com.minitienda.minitienda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    
    @GetMapping("/hello") 
    @ResponseBody
    public String mostrarHello(){
        return "Bienvenido a mi tienda";
    }

    @GetMapping("/description")
    @ResponseBody
    public String descripcion(){
        return "MI MiniTienda es la mejor tienda de productos virtuales";
    }

    @GetMapping("/products")
    @ResponseBody
    public String listarProductos() {
    return "Producto 1: MasterCorn XL, Producto 2: Papa Delta";
    }

    @GetMapping("/date")
    @ResponseBody
    public String date() {
    return "Fecha actual: " + java.time.LocalDate.now();
    }
}

