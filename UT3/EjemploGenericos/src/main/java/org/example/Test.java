package org.example;

public class Test {
    public static void main(String[] args) {
        CajaObject c = new CajaObject("hola amigos");
        CajaObject c2 = new CajaObject(25);
        CajaObject c3 = new CajaObject(new Persona("pepe",30));

        String cadena = (String)c.getDato(); //este primer problema se resuelve con el casting
        int numero = (int)c.getDato(); //no hay seguridad en los tipos de datos, me puedo confundir, como en este código
                                        //este problema es en tiempo de ejecución mucho más dificil de ver

        Caja <String> caja1 = new Caja<>("hola amigos");
        Caja <Integer> caja2 = new Caja<>(25);
        Caja <Persona> caja3 = new Caja<>(new Persona("pepe",30));

        String cadena2 = caja1.getDato();
        Integer numero2 = caja2.getDato();
        Persona p = caja3.getDato();
    }
}
