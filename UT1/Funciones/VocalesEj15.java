import java.util.Scanner;

public class VocalesEj15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = "reconocer";
        System.out.println("numero de vocales = " + cuentaVocales(frase));
        if (esPalindromo(frase)) {
            System.out.println("Palindromo");
        } else {
            System.out.println("no es palindromo");
        }

        int numero;
        System.out.println("Introduce un numero: ");
        numero = sc.nextInt();

    }

    public static int cuentaVocales(String frase) {
        int cont = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u' ||
                    frase.charAt(i) == 'A' || frase.charAt(i) == 'E' || frase.charAt(i) == 'I' || frase.charAt(i) == 'O' || frase.charAt(i) == 'U') {
                cont++;
            }
        }
        return cont;
    }


    //RECONOCER


    public static boolean esPalindromo(String frase) {
        boolean esPalindromo = true;
        for (int i = 0; i < frase.length() / 2 && esPalindromo; i++) {
            if (frase.charAt(i) != frase.charAt(frase.length() - i - 1)) {
                esPalindromo = false;
            }
        }
        return esPalindromo;
    }
}

