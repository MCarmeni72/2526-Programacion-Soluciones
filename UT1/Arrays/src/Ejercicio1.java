import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1. Escribe un programa que pida al usuario cuántos alumnos tiene un grupo.
 * 2. Después debe pedir las notas de cada alumno de ese grupo usando una estructura adecuada.
 * 3. El programa debe mostrar las notas introducidas,
 * 4. La media de todas las notas,
 * 5. La nota más alta
 * 6. la nota más baja.
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        //1. Pedir numero de alumnos y crear array para ese numero de alumnos
        int numAlumnos = pideEntero("Introduce número de alumnos","Error, debes introducir un numero entero");
        int []notas = new int[numAlumnos];

        //2. Recoger las notas de cada alumno en el array
        for(int i=0;i<notas.length;i++){
            notas[i]=pideEntero("Introduce nota "+i+": ","Error,La nota debe ser un numero entero");
        }
        //3.Mostrar por pantalla las notas.
        for(int i=0;i<notas.length;i++){
            System.out.println("Nota["+i+"]: "+notas[i]);
        }
        //4.Calcular la media.
        double media = 0;
        for(int i=0;i<notas.length;i++){
            media+=notas[i];
        }
        media = media/notas.length;
        System.out.println("Media: "+media);

        //5.Calcular la nota máxima.
        int notaMaxima=notas[0];
        for(int i=0;i<notas.length;i++){
            if(notas[i]>notaMaxima){
                notaMaxima=notas[i];
            }
        }
        System.out.println("Nota maxima: "+notaMaxima);

        //6.Calcular la nota mínima
        int notaMinima=notas[0];
        for(int i=0;i<notas.length;i++){
            if(notas[i]<notaMinima){
                notaMinima=notas[i];
            }
        }
        System.out.println("Nota minima: "+notaMinima);

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
