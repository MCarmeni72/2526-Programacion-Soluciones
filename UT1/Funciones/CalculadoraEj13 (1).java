public class CalculadoraEj13 {
    public static void main(String[] args) {
        double numero1=5,numero2=3;
        char signo = '*';
        System.out.println(numero1+" "+signo+" "+numero2+" = "+calculaOperacion(numero1,numero2,signo));
    }

    public static double calculaOperacion(double num1, double num2, char signo) {
        double resultado = 0;
        switch (signo) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                resultado = num1 / num2;
                break;
        }

        return resultado;
    }


}
