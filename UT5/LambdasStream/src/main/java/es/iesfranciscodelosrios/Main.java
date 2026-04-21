package es.iesfranciscodelosrios;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Beatriz", "David");

        // Usamos forEach con una función lambda personalizada para imprimir cada nombre
        nombres.forEach(nombre -> {
            String mensaje = "Nombre: " + nombre;
            System.out.println(mensaje);
        });

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Usamos forEach con una lambda personalizada para incrementar y mostrar los números
        numeros.forEach(numero -> {
            int incremento = numero + 1;
            System.out.println("Número incrementado: " + incremento);
        });

        // Usamos forEach con una lambda personalizada para imprimir solo los números pares
        numeros.forEach(numero -> {
            if (numero % 2 == 0) {
                System.out.println("Número par: " + numero);
            }
        });

        numeros.forEach(System.out::println);*/

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 23));
        personas.add(new Persona("Carlos", 35));
        personas.add(new Persona("Beatriz", 30));
        personas.add(new Persona("David", 28));

        personas.sort( (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()) );

        personas.sort( (p1, p2) -> Double.compare(p2.getEdad(), p1.getEdad()));
        personas.sort( (p1, p2) -> -1 * Double.compare(p1.getEdad(), p2.getEdad()));

        personas.forEach(System.out::println);

    }
}