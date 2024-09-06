package com.ahk.arg.forsale.models.entities;

public class Zona {
    private String nombre;
    private Float precio;

    public Float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
