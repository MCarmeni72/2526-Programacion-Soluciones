import java.util.Scanner;

public class GimnasioEj15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String estadoSalud = "";
        double peso = 0, altura = 0, km = 0, imc = 0;
        int op = 0;

        do{
            System.out.println("=== Gimnasio Virtual ===");
            System.out.println(   "0. Salir del programa" +
                                "\n1. Carcular el IMC" +
                                "\n2. Calcular las calorías quemadas");
            System.out.println("Introduce una opción: ");
            op=sc.nextInt();
            switch (op){
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                case 1:
                    do {
                        System.out.println("Introduzca su altura (en metros): ");
                        altura = sc.nextDouble();
                        if(altura<=0){
                            System.out.println("La altura debe ser mayor a 0!");
                        }
                    }while(altura<=0);

                    //con el peso podríamos hacer igual que la altura para evitar valores negativos
                    System.out.println("Introduzca su peso (en kilogramos): ");
                    peso=sc.nextDouble();
                    imc=peso/(altura*altura);
                    if(imc<18.5){
                        estadoSalud="bajo peso";
                    }else if(imc>=18.5&&imc<=24.9){
                        estadoSalud="peso normal";
                    }else if(imc>=25&&imc<=29.9){
                        estadoSalud="sobrepeso";
                    }else{
                        estadoSalud="obesidad";
                    }
                    System.out.println("Según su imc: "+imc+" estás en "+estadoSalud);
                    break;
                case 2:
                    System.out.println("Introduce los kilometros que has corrido: ");
                    km=sc.nextDouble();
                    System.out.println("Has quemado "+km*60+" calorías.");
                    break;
                default:
                    System.out.println("ERROR! La opción introducida es incorrecta.");
            }
        }while(op!=0);

    }
}
