public class NotaEj17 {
    public static void main(String[] args) {
        String resultado = devuelveCalificacion(3);
        System.out.println(resultado);
    }

    public static String devuelveCalificacion(int nota) {
        String resultado = "";
        switch (nota) {
            case 0, 1, 2, 3, 4:
                resultado = "Insuficiente";
                break;
            case 5:
                resultado = "Suficiente";
                break;
            case 6:
                resultado = "Bien";
                break;

            case 7, 8:
                resultado = "Notable";
                break;

            case 9, 10:
                resultado = "Sobresaliente";
                break;
            default:
                resultado = "No se pudo asignar la nota, valor numérico incorrecto";

        }

        //opción con if. Igual de válida

        /*if (nota >= 0 && nota <= 4) {
            resultado = "Insuficiente";
        } else if (nota == 5) {
            resultado = "Suficiente";
        } else if (nota == 6) {
            resultado = "Bien";
        } else if (nota == 7 || nota == 8) {
            resultado = "Notable";
        } else if (nota == 9 || nota == 10) {
            resultado = "Sobresaliente";
        } else {
            resultado = "No se pudo asignar la nota, valor numérico incorrecto";
        }
*/
        return resultado;
    }
}
