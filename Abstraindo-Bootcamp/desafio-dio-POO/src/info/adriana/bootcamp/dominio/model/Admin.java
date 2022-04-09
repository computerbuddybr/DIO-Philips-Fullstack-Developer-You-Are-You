package info.adriana.bootcamp.dominio.model;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe que administra a criação de Bootcamps
 */
public class Admin{
    private Set<Bootcamp> bootcamps = new LinkedHashSet<>();
    private Set<Dev> devs = new LinkedHashSet<>();

    public Set<Bootcamp> getBootcamps() {
        return bootcamps;
    }

    public Set<Dev> getDevs() {
        return devs;
    }

    /**
     * Criando um bootcamp novo
     */
    public void createBootcamp(){
        Scanner entrada = new Scanner(System.in);
        String nome, descricao;
        System.out.println("Qual o nome do bootcamp: ");
        nome = entrada.nextLine();
        System.out.println("Qual a descrição do bootcamp: ");
        descricao = entrada.nextLine();
        bootcamps.add(new Bootcamp(nome,descricao));
        entrada.close();

    }
    /**
     * Adicionando conteudo ao bootcamp novo
     */
    public void adicionandoConteudo(Bootcamp bootcamp){

        Scanner entrada = new Scanner(System.in);
        String nome, descricao;
        int tipo;
        System.out.println("Qual o nome do conteúdo: ");
        nome = entrada.nextLine();
        System.out.println("Qual a descrição do conteúdo: ");
        descricao = entrada.nextLine();
        System.out.println("É uma mentoria ou curso? Digite 1 para mentoria e 2 para curso.");
        tipo = Integer.parseInt(entrada.nextLine());
        while(tipo != 1 && tipo != 2){
            System.out.println("Você digitou um valor inválido. Digite 1 para mentoria e 2 para curso.");
            tipo = Integer.parseInt(entrada.nextLine());
        }
        if(tipo == 2){
            System.out.println("Qual a carca horária?");
            int cargaHoraria = Integer.parseInt(entrada.nextLine());
            bootcamp.adicionarConteudo(new Curso(nome, descricao, cargaHoraria));
        } else if(tipo == 1){
            bootcamp.adicionarConteudo(new Mentoria(nome, descricao));
        }

        entrada.close();

    }

    /**
     * Registrando um dev novo na plataforma
     * @param bootcamp
     */

    public void registrarDev(Bootcamp bootcamp){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual o nome do dev: ");
        String nome = entrada.nextLine();
        entrada.close();
        devs.add(new Dev(nome));

    }

    /**
     * matriculando um Dev em um Bootcamp
     * @param bootcamp
     * @param dev
     */

    public void matricularDevEmBootcamp(Bootcamp bootcamp, Dev dev){
        dev.inscreverBootcamp(bootcamp);
    }

    /**
     * Função para teste criando listas de devs e bootcamps
     */

    public void teste(){
        //Devs teste
        Dev adriana = new Dev("Adriana Cerdeira");
        Dev paula = new Dev("Paula Silva");
        Dev max = new Dev("Max Souza");
        Dev marcia = new Dev("Marcia Chap");
        Dev laura = new Dev("Laura Cerdeira");

       //Bootcamp teste
        Bootcamp java = new Bootcamp("Java", "Aprendendo Java do 0");
        Bootcamp python = new Bootcamp("Python", "Aprendendo Python do 0");
        Bootcamp js = new Bootcamp("js", "Aprendendo JS do 0");
        Bootcamp php = new Bootcamp("PHP", "Aprendendo PHP do 0");


        //Cursos teste
        Curso phpInicial = new Curso("PHP básico", "Começando no PHP.", 20);
        Curso html = new Curso("HTML Completo", "Tudo que você precisa saber de HTML.", 80);
        Curso cursoJS = new Curso("JS do 0 ao Avançado", "Tudo que você queria saber de JS e tinha medo de perguntar.", 150);
        Curso cursoJava = new Curso("Entendendo Java", "Descomplicando e desmitificando o Java.", 200);
        Curso cursoPHP = new Curso("PHP 8.0", "PHP do básico ao avançado.", 200);
        Curso cursoPython = new Curso("Python", "Entendo Data Science com Python.", 150);
        Curso css = new Curso("CSS", "Deixando tudo bonito", 50);


        //Mentorias teste
        Mentoria desafiosDeCodigo = new Mentoria("Desafios de código", "Como fazer os desafios.");
        Mentoria comecando = new Mentoria("Começando um Bootcamp", "Me inscrevi no Bootcamp e agora?");
        Mentoria conseguindoTrabalho = new Mentoria("Conseguindo Trabalho Dev", "Como fazer para conseguir a tão desejada vaga dev!");

       //Adicionando conteúdo aos Bootcamps
        java.adicionarConteudo(html);
        java.adicionarConteudo(css);
        java.adicionarConteudo(cursoJS);
        java.adicionarConteudo(cursoJava);

        java.adicionarConteudo(desafiosDeCodigo);
        java.adicionarConteudo(comecando);
        java.adicionarConteudo(conseguindoTrabalho);

        python.adicionarConteudo(html);
        python.adicionarConteudo(css);
        python.adicionarConteudo(cursoJS);
        java.adicionarConteudo(cursoPython);

        python.adicionarConteudo(desafiosDeCodigo);
        python.adicionarConteudo(comecando);
        python.adicionarConteudo(conseguindoTrabalho);


        php.adicionarConteudo(html);
        php.adicionarConteudo(css);
        php.adicionarConteudo(cursoJS);
        php.adicionarConteudo(cursoPHP);

        php.adicionarConteudo(desafiosDeCodigo);
        php.adicionarConteudo(comecando);
        php.adicionarConteudo(conseguindoTrabalho);


        js.adicionarConteudo(html);
        js.adicionarConteudo(css);
        js.adicionarConteudo(cursoJS);


        js.adicionarConteudo(desafiosDeCodigo);
        js.adicionarConteudo(comecando);
        js.adicionarConteudo(conseguindoTrabalho);


        //Matriculando devs nos Bootcamps
        this.matricularDevEmBootcamp(java, adriana);
        this.matricularDevEmBootcamp(java, paula);
        this.matricularDevEmBootcamp(java, max);

        this.matricularDevEmBootcamp(python, marcia);
        this.matricularDevEmBootcamp(python, adriana);
        this.matricularDevEmBootcamp(python, laura);

        this.matricularDevEmBootcamp(js, paula);
        this.matricularDevEmBootcamp(js, laura);
        this.matricularDevEmBootcamp(js, max);

        this.matricularDevEmBootcamp(php, laura);
        this.matricularDevEmBootcamp(php, adriana);
        this.matricularDevEmBootcamp(php, max);

        //Criando lista devs
        this.devs.add(adriana);
        this.devs.add(paula);
        this.devs.add(max);
        this.devs.add(marcia);
        this.devs.add(laura);

        //Criando lista bootcamps
        this.bootcamps.add(java);
        this.bootcamps.add(js);
        this.bootcamps.add(python);
        this.bootcamps.add(php);
    }

    /**
     * Mostrando o conteúdo das outras classes
     */
    public void mostrarDev(Dev dev){
        System.out.println(dev);
    }
    public void mostrarBootcamp(Bootcamp bootcamp){
        System.out.println(bootcamp);
    }
    public void mostrarCurso(Curso curso){
        System.out.println(curso);
    }
    public void mostrarMentoria(Mentoria mentoria){
        System.out.println(mentoria);
    }
}
