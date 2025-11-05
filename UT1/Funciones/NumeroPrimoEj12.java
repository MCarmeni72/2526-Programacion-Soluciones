public class NumeroPrimoEj12 {
    public static void main(String[] args) {
        int numero = 7;

        if(esPrimo(numero)){
            System.out.println("El numero es primo");
        }else {
            System.out.println("El numero no es primo");
        }
    }

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
}
