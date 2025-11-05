public class EjerciciosFuncionesBasicos {
    public static void main(String[] args) {
        int numero1 = 8;
        int numero2 = 15;

        mostrarSaludo();
        mostrarSaludoPersonalizado("Cenicienta");
        System.out.println("El mayor entre " + numero1 + " y " + numero2 + " es: " + calcularMayor(numero1, numero2));
        System.out.println("El cuadrado de " + numero1 + " es: " + calcularCuadrado(numero1));

        if (esPar(numero1)) {
            System.out.println(numero1 + " es par");
        } else {
            System.out.println(numero1 + " no es par");
        }
        System.out.println("25ºC son " + celsiusToFahrenheit(25) + "ºF");
        System.out.println("1219 € son "+ eurosADolares(1219) + " $");

        System.out.println("El promedio de 3, 10 y 14 es: " + promedio(3,10,15));

        System.out.println("El valor absoluto de "+ numero1 + " es " + valorAbsoluto(numero1));

        System.out.println(esVocalOConsonante('a'));
        System.out.println(esVocalOConsonante('A'));
        System.out.println(esVocalOConsonante('b'));
        System.out.println(esVocalOConsonante('B'));
        System.out.println(esVocalOConsonante('$'));

        System.out.println(sumaEnterosEntre(1,5));
    }

    public static void mostrarSaludo() {
        System.out.println("Hola, estamos viendo funciones");
    }

    public static void mostrarSaludoPersonalizado(String nombre) {
        System.out.println("Hola " + nombre + ", estamos viendo funciones");
    }

    public static int calcularMayor(int a, int b) {
        int mayor = a;
        if (b > mayor) {
            mayor = b;
        }
        return mayor;
    }

    public static int calcularCuadrado(int a) {
        int cuadrado = a * a;
        return cuadrado;
    }

    public static boolean esPar(int a) {
        boolean result = false;
        if (a % 2 == 0) {
            result = true;
        }
        return result;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * (9.0 / 5.0) + 32;
    }

    public static double eurosADolares(double euros) {
        return euros * 1.16;
    }

    public static double promedio(int numero1, int numero2, int numero3) {
        return (numero1 + numero2 + numero3) / 3.0;
    }

    public static int valorAbsoluto(int numero) {
        int resultado = numero;
        if (resultado < 0) {
            resultado = resultado * -1;
        }
        return resultado;
    }

    /**
     * Esta función devuelve:
     * 0 si es vocal
     * 1 si es consonante
     * -1 si no es ni vocal ni consonante
     */
    public static int esVocalOConsonante(char caracter) {
        int resultado = -1;
        if (esMayuscula(caracter)) {
            if (caracter == 'A' || caracter == 'E' ||caracter == 'I' ||caracter == 'O' ||caracter == 'U') {
                resultado = 0;
            } else {
                resultado = 1;
            }
        } else if (esMinuscula(caracter)) {
            if (caracter == 'a' || caracter == 'e' ||caracter == 'i' ||caracter == 'o' ||caracter == 'u') {
                resultado = 0;
            } else {
                resultado = 1;
            }
        }
       return resultado;
    }

    public static boolean esMayuscula(char caracter) {
        boolean resultado = false;
        if (caracter >= 'A' && caracter <= 'Z') {
            resultado = true;
        }
        return resultado;
    }

    public static boolean esMinuscula(char caracter) {
        boolean resultado = false;
        if (caracter >= 'a' && caracter <= 'z') {
            resultado = true;
        }
        return resultado;
    }

    public static int sumaEnterosEntre(int numeroMenor, int numeroMayor) {
        int resultado = 0;
        for (int i = numeroMenor; i <= numeroMayor; i++) {
            resultado += i;
        }
        return resultado;
    }
}
