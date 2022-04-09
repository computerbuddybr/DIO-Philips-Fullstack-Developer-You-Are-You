package info.adriana.bootcamp.dominio.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mentoria extends Conteudo {

    private LocalDate data;
    private final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String dataFormatada;

    public Mentoria(String titulo, String descricao) {
        super(titulo, descricao, TiposDeConteudo.MENTORIA);
        this.data = LocalDate.now();
        this.dataFormatada = this.data.format(this.FORMAT);
    }

    @Override
    public double calcularXP() {
        return XP_PADRÃO + 20;
    }


    public LocalDate getData() {
        return this.data;
    }
    public String getDataFormatada(){
        return this.dataFormatada;
    }
    /**
     * Os getters
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\nMentoria:\n" +
                "\nTitulo='" + this.titulo +
                "\nDescricao='" + this.descricao +
                "\nData=" + this.dataFormatada +
                "\nXP=" + this.calcularXP();
    }


}
