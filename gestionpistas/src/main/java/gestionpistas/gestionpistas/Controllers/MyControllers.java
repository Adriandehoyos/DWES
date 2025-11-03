package gestionpistas.gestionpistas.Controllers;

import java.util.ArrayList;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import gestionpistas.gestionpistas.Model.Pista;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class MyControllers {

    public ArrayList<Pista> pistas = new ArrayList<>();


    @GetMapping("/") 
    public String mostrarPistas(Model model){

        model.addAttribute("pistas", pistas);

        return "index";
    }

    @PostMapping("/addPista")
    public String addPista(@RequestParam String nombrePista, @RequestParam String horas) {
        Pista nuevaPista = new Pista(nombrePista, horas);
        pistas.add(nuevaPista);
        return "redirect:/"; //Redirecciona a /
    }
    




}
