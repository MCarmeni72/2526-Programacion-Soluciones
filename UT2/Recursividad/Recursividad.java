public class Recursividad {
    static int sumaNumerosHasta(int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumaNumerosHasta(n - 1) + n;
        }
    }

    static int sumaNumerosHastaIterativo(int n) {
        int resultado = 0;
        for (int i = 0; i < n + 1; i++) {
            resultado += i;
        }
        return resultado;
    }

    public static void provocarStackOverflow() {
        int n = 1000000;
        long tiempoInicio, tiempoFin;
        tiempoInicio = System.currentTimeMillis();
        System.out.println("Recurrente: " + sumaNumerosHasta(n));
        tiempoFin = System.currentTimeMillis();
        System.out.println("Tiempo: "+ ( tiempoFin - tiempoInicio ) +" ms");
        tiempoInicio = System.currentTimeMillis();
        System.out.println("Iterativo: " + sumaNumerosHastaIterativo(n));
        tiempoFin = System.currentTimeMillis();
        System.out.println("Tiempo: "+ ( tiempoFin - tiempoInicio ) +" ms");
    }

    public static int factorial(int n) {
        if (n==0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int fibonacci(int n) {
        if (n==0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }



    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(fibonacci(6));
    }
}