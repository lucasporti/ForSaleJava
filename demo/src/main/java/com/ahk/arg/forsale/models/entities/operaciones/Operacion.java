package com.ahk.arg.forsale.models.entities.operaciones;

import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.personas.Empleado;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public abstract class Operacion {
    protected Inmueble inmueble;

    public abstract Float calcularComisionParaEmpleado(Empleado empleado);
}
