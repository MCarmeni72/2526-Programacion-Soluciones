package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    private String nombre;
    private int edad;

    public CategoriaPersona getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPersona categoria) {
        this.categoria = categoria;
    }

    private CategoriaPersona categoria;

    //para JaxB es necesario el constructor por defecto
    public Persona(){}

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
