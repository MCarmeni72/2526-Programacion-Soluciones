import java.util.Scanner;

/**
 * Cajero automático: Pedir un número y mostrar cómo se descompone en billetes de 50, 20, 10 y 5
 * (simulación de un cajero). El importe introducido solo será admitido si es divisible por 5
 * (por ejemplo 232 euros, no es válido. 235 sí). Si se introduce una cantidad no válida volverá
 * a pedirla, indicando el error.
 */
public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int importe = 0;
        int cont50 = 0, cont20=0, cont10=0, cont5=0;
        do{
            System.out.println("Introduce importe: ");
            importe = sc.nextInt();
            if(importe%5!=0) {
                System.out.println("Vuelve a intentarlo, debe ser multiplo de 5");
            }
        }while(importe%5!=0);

        cont50 = importe/50;
        importe = importe-(cont50 * 50);
        cont20 = (importe/20);
        importe = importe-(cont20 * 20);
        cont10 = (importe/10);
        importe = importe-(cont10 * 10);
        cont5 = importe/5;
        System.out.println("Se necesitan: \n"
                +cont50+" billetes de 50\n"
                +cont20+" billetes de 20\n"
                +cont10+" billetes de 10\n"
                +cont5+" billetes de 5");

    }
}
