import info.adrianacerdeira.desafio_poo.*;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Dev> devs = new LinkedHashSet<>();

        //Criando os cursos
        Course course1 = new Course("Java Inciante", "Vamos começar a programar em Java!", 20);
        Course course2 = new Course("Java Avançado", "Agora que você já sabe o básico, vamos avançar no seu desenvolvimento", 60);

        //Criando as mentorias
        Mentorship mentorship1 = new Mentorship("Como avançar no Bootcamp", "O que você pode fazer para avvançar rapidamente no Bootcamp");
        Mentorship mentorship2 = new Mentorship("Resolvendo os desafios", "Como resolvemos os rápidos desafios de código");

        //Criando um Bootcamp
        Bootcamp bootcamp = new Bootcamp("Java Web Developer", "Java também pode ser usado pra Web!");

        //Adicionando o conteúdo ao Bootcamp
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(course2);
        bootcamp.getContents().add(mentorship1);
        bootcamp.getContents().add(mentorship2);

        //Criando devs
        devs.add(new Dev("Adriana Cerdeira"));
        devs.add(new Dev("Paula Laura"));
        devs.add(new Dev("Laura Cerdeira"));
        devs.add(new Dev("Joana Silva"));


        //Inscrevendo Devs no bootcamp criado
        for (Dev dev :
                devs) {
            dev.subscribeBootcamp(bootcamp);
        }


        //Fazendo Print da Informação de Adriana e progredindo Adriana
        System.out.println("Para o Bootcamp: " + bootcamp + "\n\nTemos os seguintes devs:\n");
        int count = 1; //variável de controle para progradir os devs de modo diferente
        for (Dev dev :
                devs) {
            System.out.println();
            System.out.println("/*----------------*/\n");
            showContent(dev);
            //Progredindo o dev
            for (int i = 1; i <= count; i++) {
                dev.progress();
            }
            count++;

            System.out.println("\nDepois de progredir:");
            showContent(dev);
            System.out.println();
            //Calculando o XP do Dev
            System.out.println("XP do Dev:" + dev.calculateTotalXp());
        }

    }


    public static void showContent(Dev dev) {
        System.out.println("Conteúdos Inscritos de " + dev.getName() + ":");
        Set<Content> subscribedContent = new LinkedHashSet<>();
        Set<Content> finishedContent = new LinkedHashSet<>();
        subscribedContent.addAll(dev.getSubscribedContent());
        finishedContent.addAll(dev.getFinishedContent());
        for (Content content :
                subscribedContent) {
            System.out.println(content);

        }
        System.out.println("Conteúdos Finalizados de " + dev.getName() + ":");
        for (Content content :
                finishedContent) {
            System.out.println(content);

        }
    }
}
