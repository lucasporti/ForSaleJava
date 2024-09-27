package com.ahk.arg.forsale.models.entities; //este archivo pertenece a este packete

import com.ahk.arg.forsale.models.entities.operaciones.Operacion;
import com.ahk.arg.forsale.models.entities.operaciones.estados.EstadoOperacion;
import lombok.Getter;
import lombok.Setter;

//modificadore de acceso privete, protective, public
@Setter
@Getter
public abstract class Inmueble {
    protected Integer cantAmbientes;
    protected Float tamanioEnM2;
    private  Zona zona;
    private Operacion operacion;
    private Integer id;

    public abstract float precio();

    public abstract String tipo();

    public Float precioFinal() {
        return this.precio() + this.zona.getPrecio();
    }

}