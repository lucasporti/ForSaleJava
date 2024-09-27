package com.ahk.arg.forsale.models.entities.operaciones.estados;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Cliente;
import com.ahk.arg.forsale.models.entities.personas.Empleado;

public class Concretada implements EstadoOperacion{

    public Concretada(Empleado empleado, Inmueble inmueble){
        inmueble.getOperacion().calcularComisionPara(empleado);
    }

    @Override
    public void reservar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede reservar el inmueble porque ya fue concretado.");
    }

    @Override
    public void concretar(Inmueble inmueble, Cliente cliente, Empleado empleado) {
        throw new RuntimeException("No se puede concretar el inmueble porque ya fue concretado.");
    }

    @Override
    public String tipo() {
        return "Concretada";
    }
}
