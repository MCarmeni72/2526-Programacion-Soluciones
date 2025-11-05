import java.util.Scanner;

/**
 * Máximo y mínimo: Pedir al usuario 10 números y mostrar el mayor y el menor.
 */
public class MaximoMinimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero=0;
        int mayor=0;
        int menor=0;

        for(int i=0;i<10;i++){
            System.out.println("Introduce un numero: ");
            numero = sc.nextInt();
            //solo en la primera vuelta, doy el valor inicial a mayor y menor
            //con el primer número introducido
            if(i==0){
                mayor=numero;
                menor=numero;
            }else { //todas las vueltas menos la primera, comparo para saber si es menor o mayor
                if(numero>mayor){
                    mayor=numero;
                }
                if(numero<menor){
                    menor=numero;
                }
            }
        }
        System.out.println("El mayor numero es: "+mayor);
        System.out.println("El menor numero es: "+menor);


    }
}
