package info.adriana.bootcamp.dominio.model;

import java.util.*;

public class Dev {

    protected int codigo;
    protected String nome;
    protected Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    protected Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    protected Set<Bootcamp> bootcamps = new LinkedHashSet<>();


    Dev(){

    }

    Dev(String nome) {
        this.nome = nome;

    }

    /**
     * Inserindo na lista de conteúdos o conteúdo do Bootcamp
     * @param bootcamp
     */
    void inscreverBootcamp(Bootcamp bootcamp){


        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    void progredirNoBootcamp(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.out.println("Você não está matriculado em nenhum conteúdo");
        }
    }
    double calcularTotalXP(){
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }


    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public String toString() {
        return "\nDev: \n" +
                "Nome: " + nome +
                "\n Inscrito nos conteúdos: " + conteudosInscritos +
                "\n Concluíu os conteúdos: " + conteudosConcluidos +
                "\nXP total: " +  this.calcularTotalXP();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
