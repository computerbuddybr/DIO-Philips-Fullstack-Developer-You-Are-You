import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        //Para me ajudar a dar debug
        System.out.println("Favor digitar seu tweet: ");
        String T = leitor.nextLine();
        //Está é a resposta que passa no desafio
        System.out.println(T.length() > 140 ? "MUTE" : "TWEET");
        //Esta é uma testagem que acho mais interessante. Também para ver se não está vazio o tweet
        int tamanhoTweet = T.length();
        System.out.println((tamanhoTweet == 0 || tamanhoTweet > 140) ? "MUTE" : "TWEET");
    }
}
