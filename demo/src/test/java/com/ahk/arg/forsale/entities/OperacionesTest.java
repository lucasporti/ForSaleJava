package com.ahk.arg.forsale.entities;

import com.ahk.arg.forsale.models.entities.Casa;
import com.ahk.arg.forsale.models.entities.Inmueble;
import com.ahk.arg.forsale.models.entities.Zona;
import com.ahk.arg.forsale.models.entities.operaciones.Alquiler;
import com.ahk.arg.forsale.models.entities.personas.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperacionesTest {
    private Inmueble inmueble;

    @BeforeEach
    public void init(){
        Zona zona1 = new Zona();
        zona1.setPrecio(10F);

        Casa unaCasa = new Casa();
        unaCasa.setValor(100F);
        this.inmueble = unaCasa;
        this.inmueble.setZona(zona1);
    }

    @Test
    @DisplayName("Alquiler de 3 meses genera una comisión de 10")
    public void calculoComisionAlquiler(){
        Empleado empleado = new Empleado();

        Alquiler unAlquiler = new Alquiler();
        unAlquiler.setInmueble(this.inmueble);
        unAlquiler.setCantMeses(3);

        Float comisionObtenida = unAlquiler.calcularComisionParaEmpleado(empleado);

        Assertions.assertEquals(0.0022F, comisionObtenida);
    }
}
