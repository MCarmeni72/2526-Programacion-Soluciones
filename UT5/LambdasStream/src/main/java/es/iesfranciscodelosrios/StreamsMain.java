package es.iesfranciscodelosrios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMain {
    static void main() {
        List<Integer> lista = List.of(-1, -2, 3, 4, -5, 6, 2);
        List<Integer> negativos = new ArrayList<>();
        lista.stream().filter(numero -> numero < 0 ).forEach(numero -> negativos.add(numero));
        System.out.println(negativos);

        // Encontrar el primer número mayor de 3
        Integer numeroMayor3 = lista.stream().filter(numero -> numero > 3).findFirst().orElse(null);

        // Calcular cuadrados
        System.out.println("Cuadrados");
        lista.stream().map(numero -> numero * numero).filter(elemento -> elemento > 10).forEach(System.out::println);

        // Calcular suma cuadrados
        Integer resultadoSuma = lista.stream().map(numero -> numero * numero).reduce(0, (resultado, elemento) -> resultado + elemento);
        System.out.println("Suma cuadrados: " + resultadoSuma);

        List<Integer> negativos2 = lista.stream().filter(numero -> numero < 0).collect(Collectors.toList());
        System.out.println(negativos2);


        List<Integer> positivosOrdenados = lista.stream().filter(numero -> numero >= 0).sorted((numero1, numero2) -> -1 * Integer.compare(numero1, numero2)).collect(Collectors.toList());
        System.out.println(positivosOrdenados);

        List<String> nombres = Arrays.asList("Carlos", "Ana", "Pedro", "Beatriz");

        nombres.stream()
                .sorted(Comparator.comparing(String::length)) // Orden por longitud de nombre
                .forEach(System.out::println);

        nombres.stream()
                .sorted(Comparator.comparing(String::length).reversed()) // Orden inverso por longitud de nombre
                .forEach(System.out::println);
    }
}
