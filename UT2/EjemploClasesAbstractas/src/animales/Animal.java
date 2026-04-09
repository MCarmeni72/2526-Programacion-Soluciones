package animales;

import interfaces.Sonido;

public abstract class Animal implements Sonido {
    private String nombre;

    protected Animal(String nombre) {
        this.nombre = nombre;
    }

    public void dormir() {
        System.out.println("El animal está durmiendo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
