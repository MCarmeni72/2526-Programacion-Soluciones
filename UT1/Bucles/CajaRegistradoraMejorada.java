import java.util.Scanner;

/*
 * Simulador de caja registradora: Pedir precios correctos (valores positivos)
 * hasta que se introduzca un 0. Devolver el importe de la compra.
 * Mejorar el ejercicio anterior, para que cada vez que se pida un precio,
 *  pregunte si tiene descuento o no, si lo tiene, pide el porcentaje de
 * descuento (entre 0 y 100), se lo aplica y entonces lo añade a la cuenta final.
 *  Imprimir una línea por cada precio, con su importe, el descuento y el precio final.
 *  Imprimir una línea de separación (con —--) y el total al final.
 *  La siguiente imagen puede ser un ejemplo de salida:
 */
public class CajaRegistradoraMejorada {
    public static void main(String[] args) {
        double importe = 0;
        double importeFinal = 0;
        double importeTotal = 0;
        char tieneDescuento = 'n';
        double descuento = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.println("=== Simulador de Caja Registradora ===");

        do {
            System.out.print("Introduce precios (0 para terminar): ");
            importe = teclado.nextDouble();
            if (importe > 0) {
                System.out.print("¿El producto tiene descuento? (s/n): ");
                tieneDescuento = teclado.next().charAt(0);
                if (tieneDescuento == 's') {
                    System.out.println("Introduzca el porcentaje de descuento (0-100): ");
                    descuento = teclado.nextDouble();
                } else {
                    descuento = 0;
                }
                importeFinal = importe * ((100-descuento)/100);
                System.out.println("Precio: " + importe + " € | Descuento: " + descuento + " % | Final: " + importeFinal + " €");
                importeTotal += importeFinal;
            } else if (importe < 0) {
                System.out.println("El importe no puede ser negativo");
            }
        } while (importe != 0);
        System.out.println("-------------------------------------");
        System.out.println("Total compra: " + importeTotal + " €");
    }
}
