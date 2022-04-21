package info.adrianacerdeira.desafio_poo;

import java.time.LocalDate;

public class Mentorship extends Content {

    //Passei a inicialização da data para o contrutor pensando em um CRUD futuro onde também teria a opção de obter as datas da DB;
    private LocalDate airDate;

    @Override
    public double calculateXp() {
        return STANDARD_XP + 20d;
    }

    public Mentorship(LocalDate airDate) {
        this.airDate = airDate;
    }

    public Mentorship(String name, String description) {
        super(name, description);
        //Pensando que o administrador cria a mentoria 20 dias antes de sua exibição
        this.airDate = LocalDate.now().plusDays(20);
    }

    //Resolvi retornar a data já formatada por questão de visualização
    public String getAirDate() {

        return airDate.format(this.FORMAT);
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
    }

    //Mudei a formatação para melhor visualização no terminal
    @Override
    public String toString() {
        return "\nMentoria: " + getName() +
                "\nData de exibição: " + getAirDate() +
                "\nDescrição: " + getDescription() + "\n";
    }
}
