/*
F = (C*9/5)+32

C=((°F−32)×5)/9 */

import java.util.Scanner;

public class MenuCelsiusFarenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char opcion = ' ';
        double gradosCelsius, gradosFarenheit;
        do {
            System.out.println("a. Celsius -> Farenheit");
            System.out.println("b. Farenheit -> Celsius");
            System.out.println("c. Salir");
            System.out.println("Introduce opcion:");
            opcion = sc.next().charAt(0);
            switch (opcion) {
                case 'a':
                    System.out.println("Introduce grados Celsius: ");
                    gradosCelsius = sc.nextDouble();
                    System.out.println("Los grados Farenheit correspondientes son: " + convierteCelFar(gradosCelsius));
                    break;
                case 'b':
                    System.out.println("Introduce grados Farenheit: ");
                    gradosFarenheit = sc.nextDouble();
                    System.out.println("Los grados Celsius correspondientes son: " + convierteFarCelsius(gradosFarenheit));
                    break;
                case 'c':
                    System.out.println("Has elegido salir de la app, gracias");
                    break;
                default:
                    System.out.println("Has elegido una opción incorrecta");
            }

        }while (opcion != 'c');

    }


    public static double convierteCelFar(double gradosCelsius) {
        double farenheit = gradosCelsius * 1.8 + 32;
        return farenheit;
    }

    public static double convierteFarCelsius(double gradosFar) {
        return ((gradosFar - 32) * 5) / 9;
    }


}
