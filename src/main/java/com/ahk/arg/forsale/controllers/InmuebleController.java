package com.ahk.arg.forsale.controllers;

import com.ahk.arg.forsale.models.entities.Casa;
import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.Zona;
import com.ahk.arg.forsale.models.entities.operaciones.Alquiler;
import com.ahk.arg.forsale.models.entities.operaciones.estados.Publicada;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/inmuebles")
public class InmuebleController {
    private List<Inmueble> inmuebles;
    private List<Empleado> empleados;
    private List<Cliente> clientes;

    public InmuebleController(){
        inmuebles = new ArrayList<>();
        empleados = new ArrayList<>();
        clientes = new ArrayList<>();

        Zona unaZona = new Zona();
        unaZona.setNombre("Villa Anita");
        unaZona.setPrecio(150F);
        Casa unaCasa = new Casa();
        unaCasa.setId(5);
        unaCasa.setZona(unaZona);
        unaCasa.setCantAmbientes(5);
        unaCasa.setTamanioEnM2(40F);
        unaCasa.setOperacion(new Alquiler());
        unaCasa.getOperacion().setEstado(new Publicada());
        this.inmuebles.add(unaCasa);

        Empleado empleado1 = new Empleado();
        empleado1.setNombre("Lucas");
        empleado1.setId(3);
        this.empleados.add(empleado1);

        Empleado empleado2 = new Empleado();
        empleado2.setId(6);
        empleado2.setNombre("Nacho");
        this.empleados.add(empleado2);

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Eze");
        this.clientes.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Valentino");
        this.clientes.add(cliente2);
    }

    @PostMapping("/{id}/reservar")
    public RedirectView reservarInmueble(
            @PathVariable Integer id,
            @RequestParam Integer empleado,
            @RequestParam Integer cliente
    ) {
        Inmueble inmueble = this.inmuebles
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .get();

        Empleado empleadon = this.empleados
                .stream()
                .filter(e -> e.getId().equals(empleado))
                .findFirst()
                .get();

        Cliente clienton = this.clientes
                .stream()
                .filter(f -> f.getId().equals(cliente))
                .findFirst()
                .get();

        empleado.registrarReserva(clienton, inmueble);
        return new RedirectView("/inmuebles");
    }



    @GetMapping("/{id}/reservar")
    public ModelAndView reservar(@PathVariable Integer id, Map<String, Object> model){
        model.put("title", "Formulario reservar");
        model.put("empleados", this.empleados);
        model.put("clientes", this.clientes);
        model.put("inmuebleId", id);
        return new ModelAndView("reservar", model);
    }

    @GetMapping("/{id}/concretar")
    public ModelAndView concretar(@PathVariable Integer id, Map<String, Object> model){
        model.put("title", "Formulario concretar");
        return new ModelAndView("concretar", model);
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
