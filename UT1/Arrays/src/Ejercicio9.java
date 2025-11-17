/*
 * 9. Realizar un método que busque un elemento dentro de un array de enteros y devuelva su posición, si el elemento no se encuentra, devuelve -1. Realiza un programa para probarlo.
 */
public class Ejercicio9 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int posicionElemento = buscarElemento(array, 1);
        if (posicionElemento == -1) {
            System.out.println("El 1 no está en el array");
        } else {
            System.out.println("El 1 está en el array");
        }

        posicionElemento = buscarElemento(array, 6);
        if (posicionElemento == -1) {
            System.out.println("El 6 no está en el array");
        } else {
            System.out.println("El 6 está en el array");
        }
    }

    /**
     * Devuelve la posición, y si no existe devuelve -1
     */
    public static int buscarElemento(int[] array, int elementoABuscar) {
        int posicionElemento = -1;
        int i = 0;
        while (i < array.length && posicionElemento == -1) {
            if (array[i] == elementoABuscar) {
                posicionElemento = i;
            }
            i++;
        }
        return posicionElemento;
    }
}