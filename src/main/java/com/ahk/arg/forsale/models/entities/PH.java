package com.ahk.arg.forsale.models.entities;

public class PH extends Inmueble{

    @Override
    public float precio() {
        // Super hace referencia a la clase padre
        return 500000 + 14000 * super.tamanioEnM2;
    }
}
