
import java.util.InputMismatchException;
import java.util.Scanner;
public class TryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.print("Introduce un número: ");
            try {
                int numero = sc.nextInt(); // esto puede fallar si escriben texto
                int resultado = 10 / numero;
                System.out.println("El resultado es: " + resultado);
            } catch (ArithmeticException e) {
                System.out.println("El número introducido no puede ser 0.");
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("El caracter introducido no es numérico.");
                System.out.println(e.getMessage());
            }
        System.out.println("El programa sigue funcionando.");
    }
}

