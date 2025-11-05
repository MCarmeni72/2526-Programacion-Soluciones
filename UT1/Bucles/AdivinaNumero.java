import java.util.Scanner;

/**
 * Adivina el número: El programa genera un número aleatorio entre 1 y 100, y el usuario debe adivinarlo.
 * El bucle termina cuando acierta o cuando llega al intento 20. Si acierta muestra el numero de intentos hasta
 * acertar y lo indica. Si llega a los 20 intentos sin acertar, dice que has perdido...
 * int numero = (int)(Math.random() * 100) + 1;
 */
public class AdivinaNumero {
    static final int INTENTOS_MAX = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numeroAleatorio = (int)(Math.random() * 100) + 1;
        System.out.println("Numero Aleatorio: " + numeroAleatorio);
        int numero=0, contIntentos=0;

        do{
            System.out.println("Introduce un numero: ");
            numero = sc.nextInt();
            contIntentos++;
        }while((numero != numeroAleatorio) && (contIntentos < INTENTOS_MAX));


        if(contIntentos < INTENTOS_MAX){
            System.out.println("has acertado en el intento número "+contIntentos);
        }else{
            System.out.println("No has acertado, has agotado el número de intentos. El número secreto es: "+numeroAleatorio);
        }

    }
}
