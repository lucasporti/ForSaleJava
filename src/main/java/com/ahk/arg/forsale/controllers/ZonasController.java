package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zonas")
public class ZonasController {

    private List<Zona> zonas;

    public ZonasController(){
        this.zonas = new ArrayList<Zona>();
        Zona unaZona = new Zona();
        unaZona.setId(1);
        unaZona.setNombre("Palermo Soho");
        unaZona.setPrecio(150F);

        this.zonas.add(unaZona);

        Zona otraZona = new Zona();
        otraZona.setId(3);
        otraZona.setNombre("Villa Anita");
        otraZona.setPrecio(1200F);

        this.zonas.add(otraZona);

    }

    @GetMapping
    public ModelAndView listadoDeZonas(Map<String, Object> model){
        model.put("title", "Nacho GOAT");
        model.put("zonas", this.zonas);
        return new ModelAndView("zonas", model);
    }
}