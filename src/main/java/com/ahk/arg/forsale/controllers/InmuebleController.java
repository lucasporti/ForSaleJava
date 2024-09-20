package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Casa;
import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inmuebles")
public class InmuebleController {
    private List<Inmueble> inmuebles;

    public InmuebleController(){
        inmuebles = new ArrayList<>();
        Zona unaZona = new Zona();
        unaZona.setNombre("Palermo Soho");
        unaZona.setPrecio(150F);
        Casa unaCasa = new Casa();

        unaCasa.setZona(unaZona);
        unaCasa.setCantAmbientes(5);
        unaCasa.setTamanioEnM2(40F);

        this.inmuebles.add(unaCasa);
    }
    @GetMapping
    public ModelAndView listadoDeInmuebles(Map<String, Object>model){
        model.put("title", "Inmuebles epicos");
        model.put("inmuebles", this.inmuebles);
        return new ModelAndView("inmuebles", model);
    }

    @GetMapping("/formulario-tipo-de-inmueble")
    public ModelAndView formularioTipoDeInmuebles(Map<String, Object> model){
        model.put("title", "Formulario tipo de inmueble");
        return new ModelAndView("formularioInmueble", model);
    }
}
