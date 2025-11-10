public class Ejercicio6 {
    public static void main(String[] args) {
        int[] arrayOriginal = new int[50];
        rellenaArrayAleatorio(arrayOriginal);
        int contadorPrimos = cuentaPrimos(arrayOriginal);
        int[] arrayPrimos = new int[contadorPrimos];
        rellenaArrayPrimos(arrayOriginal, arrayPrimos);
        System.out.println("ARRAY ORIGINAL: ");
        muestraArray(arrayOriginal);
        System.out.println("\nARRAY DE PRIMOS: ");
        muestraArray(arrayPrimos);

    }

    public static int generaNumeroAleatorio(int lower, int upper) {
        return (int) (Math.random() * (upper - lower + 1) + lower);
    }

    public static void rellenaArrayAleatorio(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = generaNumeroAleatorio(0, 99);
        }
    }

    /**
     * Método que devuelve true si el dato que recibe es primo, false si no lo es
     * @param numero dato entero que evaluamos para saber si es primo o no.
     * @return true si es primo, false si no es primo
     */
    public static boolean esPrimo(int numero) {
        boolean esPrimo = true;  //parto de que el numero es primo
        int i = 2;
        while (i < numero && esPrimo) {
            if (numero % i == 0) {
                esPrimo = false;
            }
            i++;
        }
        return esPrimo;
    }

    public static int cuentaPrimos(int [] array) {
        int contadorPrimos =0;
        for (int i = 1; i < array.length; i++) {
            if (esPrimo(array[i])) {
                contadorPrimos++;
            }
        }
        return contadorPrimos;
    }

    public static void rellenaArrayPrimos(int[] arrayOriginal, int[] arrayPrimos) {
        int j = 0; //indice del array de primos
        for (int i = 0; i < arrayOriginal.length; i++) {
            if (esPrimo(arrayOriginal[i])) {
                arrayPrimos[j]=arrayOriginal[i];
                j++;
            }
        }
    }

    public static void muestraArray(int [] array){
        System.out.println("Datos del array: ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }


}
