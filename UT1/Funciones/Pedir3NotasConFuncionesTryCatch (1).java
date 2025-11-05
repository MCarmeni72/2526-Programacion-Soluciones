import java.util.InputMismatchException;
import java.util.Scanner;

public class Pedir3NotasConFuncionesTryCatch {
    public static void main(String[] args) {
       /* double nota1=0, nota2=0, nota3=0;
        final double notaMinima = 0;
        final double notaMaxima = 10;
        nota1 = pideDouble(notaMinima,notaMaxima,"Introduce nota 1:","la nota introducida no es válida");
        nota2 = pideDouble(notaMinima,notaMaxima,"Introduce nota 2:","la nota introducida no es válida");
        nota3 = pideDouble(notaMinima,notaMaxima,"Introduce nota 3:","la nota introducida no es válida");
        System.out.println("Las notas introducidas son: "+nota1+", "+nota2+", "+nota3);
        */
        int numero;
        numero = pideEntero("Introduce un numero entero: ","Te has equivocado, inténtalo otra vez.");
        System.out.println("Has introducido: "+numero);
    }

    public static double pideDouble(double numeroMin, double numeroMax, String mensaje, String mensajeError){
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextDouble();
            } catch (InputMismatchException e) {
                numero = numeroMin - 1;
                sc.nextLine(); // Limpiar buffer
            }
            if(numero<numeroMin||numero>numeroMax){
                System.out.println(mensajeError);
            }
        } while(numero<numeroMin||numero>numeroMax);
      return numero;
    }

    public static int pideEntero( String mensaje, String mensajeError){
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        boolean noHayError = true;
        do {
            System.out.println(mensaje);
            try {
                numero = sc.nextInt();
                noHayError = true;
            } catch (InputMismatchException e) {
                System.out.println(mensajeError);
                noHayError = false;
                sc.nextLine(); // Limpiar buffer
            }

        } while (!noHayError);
        return numero;
    }
}
