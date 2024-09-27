package com.ahk.arg.forsale.models.entities.personas;

import com.ahk.arg.forsale.models.entities.Inmueble;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleado {
    private String nombre;
    private String apellido;
    private Float comisiones = 0F;
    private Integer id;

    public void agregarComision(Float comision) {
        this.comisiones += comision;
    }
    public void registrarReserva(Cliente cliente, Inmueble inmueble){
        inmueble.getOperacion().reservar(this, cliente);
    }

    public void concretarOperacion(Cliente cliente, Inmueble inmueble){
        inmueble.getOperacion().concretar(this, cliente);
    }
}
