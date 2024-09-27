package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Zona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    
    private List<Zona> zonas;

    public FormularioController() {
        this.zonas = new ArrayList<>();
        // Inicialización de zonas si es necesario
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
    public ModelAndView mostrarFormulario() {
        return new ModelAndView("formulario"); // La vista debe estar en src/main/resources/templates
    }

    @PostMapping("/alta")
    public String procesarFormulario(String nombre, Float precio, String descripcion) {
        Zona nuevaZona = new Zona();
        nuevaZona.setNombre(nombre);
        nuevaZona.setPrecio(precio);
        nuevaZona.setDescripcion(descripcion); // Asegúrate de que la entidad Zona tenga este campo

        // Asignar un ID único (esto es solo un ejemplo, considera usar una lógica más robusta)
        nuevaZona.setId(this.zonas.size() + 1);

        this.zonas.add(nuevaZona);

        return "redirect:/zonas"; // Redirige al listado de zonas después de procesar el formulario
    }
}
