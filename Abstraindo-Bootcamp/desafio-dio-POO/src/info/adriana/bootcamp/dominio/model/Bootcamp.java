package info.adriana.bootcamp.dominio.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    int codigo;
    String nome;
    String descricao;
    private final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataInicial;
    String dataConclusao;
    Set<Dev> devsInscritos = new HashSet<>();
    Set<Conteudo> conteudos = new LinkedHashSet<>();


    public Bootcamp(){

    }

    /**
     * Construtor para novo Bootcamp sendo criado
     * @param nome
     * @param descricao
     */
    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        LocalDate dataInicio = LocalDate.now();
        LocalDate dataFinal = dataInicio.plusDays(45);
        this.dataInicial = dataInicio.format(this.FORMAT);
        this.dataConclusao = dataFinal.format(this.FORMAT);

    }

    /**
     * Para poder adicionar um conteúdo à um Bootcamp já criado. Uma função com escopo de pacote pois é pensada para que somente os Admins e não a classe main possam alterá-la
     * @param conteudo
     */
    void adicionarConteudo(Conteudo conteudo){
        this.conteudos.add(conteudo);
    }

    /**
     * Para poder remover conteúdo de um Bootcamp criado. Uma função com escopo de pacote pois é pensada para que somente os Admins e não a classe main possam alterá-la
     * @param conteudo
     */
    void removerConteudo(Conteudo conteudo){
        this.conteudos.remove(conteudo);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicialFormatada() {
        return dataInicial;
    }

    public String getDATA_CONCLUSAO_FORMATADA() {
        return dataConclusao;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "\nBootcamp:" +
                "\nNome: " + nome +
                "\nDescricao: " + descricao +
                "\n Começa: " + dataInicial +
                "\n Deve ser entregue até" + dataConclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return codigo == bootcamp.codigo && Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(FORMAT, bootcamp.FORMAT) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataConclusao, bootcamp.dataConclusao) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, descricao, FORMAT, dataInicial, dataConclusao, devsInscritos, conteudos);
    }
}
