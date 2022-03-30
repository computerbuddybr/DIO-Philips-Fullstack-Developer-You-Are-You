import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Código meu para ajudar debugging
        System.out.println("Favor entrar a nota: ");
        int nota = input.nextInt();

        if (nota == 0) {
            System.out.println('E');
        } else if (nota >=1 && nota <=35) {
            System.out.println('D');
        } else if (nota >=36 && nota <=60) {
            System.out.println('C');
        } else if (nota >=61 && nota <=85) {
            System.out.println('B');
        } else if (nota >=86 && nota <=100) {
            System.out.println('A');
        } else {
            //Debug meu
            System.out.println("Essa não é uma nota válida. Favor inserir uma nota de 0 a 100.");
        }
        input.close();
    }
}
