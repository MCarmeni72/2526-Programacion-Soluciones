import java.util.Scanner;

/*
 * Simulador de caja registradora: Pedir precios correctos (valores positivos)
 * hasta que se introduzca un 0. Devolver el importe de la compra.
 */
public class CajaRegistradora {
    public static void main(String[] args) {
        double importe = 0;
        double importeTotal = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Simulador de Caja Registradora ===");
        do {
            System.out.print("Introduce precios (0 para terminar): ");
            importe = teclado.nextDouble();
            if (importe >= 0) {
                importeTotal += importe;
            } else {
                System.out.println("El importe no puede ser negativo");
            }
        } while (importe != 0);
        System.out.println("-------------------------------------");
        System.out.println("Total compra: " + importeTotal + " €");
    }
}
