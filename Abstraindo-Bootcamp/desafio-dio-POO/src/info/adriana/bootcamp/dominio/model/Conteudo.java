package info.adriana.bootcamp.dominio.model;

public abstract class Conteudo {
    protected int codigo;
    protected String titulo;
    protected String descricao;
    protected static final double XP_PADRÃO = 10d;
    protected TiposDeConteudo tipo;


    public Conteudo(String titulo, String descricao, TiposDeConteudo tipo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    /**
     * Os getters
     */
    public String getTitulo() {
        return titulo;
    }


    public String getDescricao() {
        return descricao;
    }


    /**
     * Método que deverá ser implementado pelos filhos
     * @return
     */
    public abstract double calcularXP();

}
