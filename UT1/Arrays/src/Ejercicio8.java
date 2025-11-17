/*
 * 8.  Realizar un método que compare 2 arrays, devolverá false si son distintos y true si son iguales. Haz un programa para probarlo.
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] arrayIgual = {1,2,3,4,5};
        int[] arrayCorto = {1,2,3,4};
        int[] arrayDiferente = {1,2,5,4,3};
        if (compararArraysEnteros(array1, arrayIgual)) {
            System.out.println("array1 y arrayIgual son iguales");
        } else {
            System.out.println("array1 y arrayIgual son diferentes");
        }

        if (compararArraysEnteros(array1, arrayCorto)) {
            System.out.println("array1 y arrayCorto son iguales");
        } else {
            System.out.println("array1 y arrayCorto son diferentes");
        }

        if (compararArraysEnteros(array1, arrayDiferente)) {
            System.out.println("array1 y arrayDiferente son iguales");
        } else {
            System.out.println("array1 y arrayDiferente son diferentes");
        }

    }
    public static boolean compararArraysEnteros(int[] array1, int[] array2) {
        boolean sonIguales = true;

        if (array1.length != array2.length) {
            sonIguales = false;
        }

        if (sonIguales) {
            for (int i = 0; i < array1.length && sonIguales; i++) {
                if (array1[i] != array2[i]) {
                    sonIguales = false;
                }
            }
//            // Equivalente
//            int i = 0;
//            while (i < array1.length && sonIguales) {
//                if (array1[i] != array2[i]) {
//                    sonIguales = false;
//                }
//                i++;
//            }
        }

        return sonIguales;
    }
}
