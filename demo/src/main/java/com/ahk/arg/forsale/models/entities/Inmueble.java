package com.ahk.arg.forsale.models.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public abstract class Inmueble {
    protected Float tamanioEnM2;
    protected Integer cantAmbientes;
    private Zona zona;

    public abstract Float precio();

    public Float precioFinal(){
        return this.precio() + this.zona.getPrecio();
    }
}
