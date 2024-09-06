package com.ahk.arg.forsale.models.entities;

public class PH extends Inmueble{

    @Override
    public Float precio() {
        return 500000 + 14000 * super.tamanioEnM2;
    }
}
