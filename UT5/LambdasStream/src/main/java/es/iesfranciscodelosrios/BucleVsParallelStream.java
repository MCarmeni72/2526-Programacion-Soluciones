package es.iesfranciscodelosrios;

import java.util.ArrayList;
import java.util.List;

public class BucleVsParallelStream {

    private static final int TOTAL_ELEMENTOS = 10_000_000;
    private static final int REPETICIONES_INTERNAS = 1000;

    public static void main(String[] args) {
        List<Integer> datos = new ArrayList<>();

        for (int i = 1; i <= TOTAL_ELEMENTOS; i++) {
            datos.add(i);
        }

        calentarJVM(datos);

        //long inicioBucle = System.nanoTime();
        //double resultadoBucle = procesarConBucle(datos);
        //long finBucle = System.nanoTime();

        long inicioParallel = System.nanoTime();
        double resultadoParallel = procesarConParallelStream(datos);
        long finParallel = System.nanoTime();

        //System.out.println("Resultado bucle:         " + resultadoBucle);
        //System.out.println("Tiempo bucle:            " + ((finBucle - inicioBucle) / 1_000_000.0) + " ms");

        System.out.println("Resultado parallelStream:" + resultadoParallel);
        System.out.println("Tiempo parallelStream:   " + ((finParallel - inicioParallel) / 1_000_000.0) + " ms");
    }

    private static void calentarJVM(List<Integer> datos) {
        // Calentamiento de la JVM
        //procesarConBucle(datos);
        procesarConParallelStream(datos);
    }

    public static double procesarConBucle(List<Integer> datos) {
        double suma = 0;

        for (int n : datos) {
            suma += calculoCostoso(n);
        }

        return suma;
    }

    public static double procesarConParallelStream(List<Integer> datos) {
        return datos.parallelStream()
                .mapToDouble(BucleVsParallelStream::calculoCostoso)
                .sum();
    }

    /**
     * Realiza varios cálculos de raices cuadradas para ejercitar la CPU
     * @param n valor inicial
     * @return resultado de la operación
     */
    public static double calculoCostoso(int n) {
        double resultado = n;

        for (int i = 0; i < REPETICIONES_INTERNAS; i++) {
            resultado = Math.sqrt(resultado + 1.0);
        }

        return resultado;
    }
}