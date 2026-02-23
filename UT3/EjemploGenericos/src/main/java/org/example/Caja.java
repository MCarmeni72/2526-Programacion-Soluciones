package org.example;

public class Caja <T>{
    private T dato;

    public Caja(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}
