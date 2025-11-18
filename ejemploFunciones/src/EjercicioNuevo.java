/**
 * Escribe el código de un método que reciba un array de enteros y devuelva otro array con todos los números anteriores
 * sin repetidos
 * Ejem: array de entrada {2,8,9,2,7,6,7,1}
 * Array de salida{2,8,9,7,6,1}
 * Haz un main para probarlo
 */
public class EjercicioNuevo {
    public static void main(String[] args) {
        int[] array = {8, 7, 6, 7, 6};
        int[] arrayRepetidos = eliminaRepetidos(array);
        for (int i = 0; i < arrayRepetidos.length; i++) {
            System.out.println(arrayRepetidos[i]);
        }
    }

    /**
     * Método que elimina los numeros repetidos en un array que recibe como parametro
     *
     * @param array que tiene que evaluar para quitar repetidos
     * @return array con los valores únicos (con los repetidos eliminados)
     */
    public static int[] eliminaRepetidos(int[] array) {
        int[] arraySinRepetidos = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (!estaRepetido(arraySinRepetidos, array[i])) {
                arraySinRepetidos[i] = array[i];
            }
        }
        return arraySinRepetidos;
    }

    public static boolean estaRepetido(int[] array, int elemento) {
        boolean estaRepetido = false; //en principio el elemento no está repetido
        int con = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] == elemento) && (con < 2)) {
                con++;
                estaRepetido = true;
            }
        }
        return estaRepetido;
    }
}
