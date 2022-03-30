import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        //Esta linha é só para me ajudar na visualização. Não adicione ao código na DIO
        System.out.println("Favor indicar o número de linhas");
        int N = leitor.nextInt();
        for (int i = 1; i <= N; i++) {
            int iAoQuadrado = (int) Math.pow(i,2);
            int iAoCubo = (int) Math.pow(i,3);
            System.out.println(i + " " +  iAoQuadrado + " " + iAoCubo);
        }
    }
}
