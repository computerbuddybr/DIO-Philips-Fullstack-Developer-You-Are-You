package info.adriana.bootcamp.dominio.model;

public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao, TiposDeConteudo.CURSO);
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * Os getters
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }


    @Override
    public String toString() {
        return "\nCurso:\n" +
                "\nTítulo: " + titulo +
                "\nDescrição: " + descricao +
                "\nCarga horária" + cargaHoraria +
                "\nXP=" + this.calcularXP();
    }


    @Override
    public double calcularXP() {
        return XP_PADRÃO + cargaHoraria;
    }
}
