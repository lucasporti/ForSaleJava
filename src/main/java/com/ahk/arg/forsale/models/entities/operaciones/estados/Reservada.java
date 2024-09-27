package com.ahk.arg.forsale.models.entities.operaciones.estados;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;

public class Reservada implements EstadoOperacion{
    private Cliente cliente;

    private Empleado empleado;

    public Reservada(Cliente cliente, Empleado empleado) {
        this.cliente = cliente;
        this.empleado = empleado;
    }

    @Override
    public void reservar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede volver a reservar, porque ya está reservado");
    }

    @Override
    public void concretar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        if(this.cliente.equals(cliente)){
            inmueble.getOperacion().setEstado(new Concretada(empleado, inmueble));
        } else{
            throw new RuntimeException("No se puede concretar la operación, porque está reservada por otro cliente");
        }
    }

    @Override
    public String tipo() {
        return "Reservada";
    }
}
