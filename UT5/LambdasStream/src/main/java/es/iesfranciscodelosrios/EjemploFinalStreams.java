package es.iesfranciscodelosrios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploFinalStreams {
    static void main() {
                // Crear una lista de objetos Persona
                List<PersonaFull> personas = new ArrayList<>();
                personas.add(new PersonaFull("Ana", 25, "Madrid"));
                personas.add(new PersonaFull("Carlos", 30, "Barcelona"));
                personas.add(new PersonaFull("Beatriz", 22, "Sevilla"));
                personas.add(new PersonaFull("David", 35, "Madrid"));
                personas.add(new PersonaFull("Elena", 28, "Valencia"));

                // 1. Filtrar personas mayores de 25 años
                System.out.println("Personas mayores de 25 años:");
                personas.stream()
                        .filter(persona -> persona.getEdad() > 25)
                        .forEach(System.out::println); // Imprimir las personas filtradas
                System.out.println();

                // 2. Transformar los nombres de las personas a mayúsculas
                System.out.println("Nombres en mayúsculas:");
                personas.stream()
                        .map(persona -> persona.getNombre().toUpperCase()) // Transformar nombre a mayúsculas
                        .forEach(System.out::println); // Imprimir los nombres transformados
                System.out.println();

                // 3. Sumar las edades de todas las personas
                int sumaEdades = personas.stream()
                        .reduce(0, (suma, persona) -> suma + persona.getEdad(), Integer::sum); // Sumar edades
                System.out.println("Suma de edades: " + sumaEdades);
                System.out.println();

                // 4. Crear una lista con los nombres de las personas
                List<String> nombres = personas.stream()
                        .map(PersonaFull::getNombre) // Extraer los nombres
                        .collect(Collectors.toList()); // Almacenar en una lista
                System.out.println("Lista de nombres: " + nombres);
                System.out.println();

                // 5. Ordenar las personas por edad (ascendente)
                System.out.println("Personas ordenadas por edad:");
                personas.stream()
                        .sorted(Comparator.comparingInt(PersonaFull::getEdad)) // Ordenar por edad
                        .forEach(System.out::println); // Imprimir personas ordenadas
                System.out.println();

                // 6. Mostrar solo las personas de Madrid
                System.out.println("Personas de Madrid:");
                personas.stream()
                        .filter(persona -> "Madrid".equals(persona.getCiudad())) // Filtrar por ciudad
                        .forEach(System.out::println); // Imprimir las personas filtradas

                // 7. Filtrar las personas mayores de 25 años, ordenar por edad, transformar los nombres a mayúsculas y recoger los resultados en una lista.

                System.out.println("Combinación de operaciones en un solo Stream:");
                List<String> resultado = personas.stream()
                        .filter(persona -> persona.getEdad() > 25)               // Filtrar mayores de 25 años
                        .sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))// Ordenar por edad ascendente
                        .map(persona -> persona.getNombre().toUpperCase())         // Transformar nombres a mayúsculas
                        .collect(Collectors.toList());                             // Recoger los resultados en una lista

                // Imprimir el resultado
                System.out.println("Resultado combinado: " + resultado);


    }
}
