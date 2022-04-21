package info.adriana.abstracaoBootcamps.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Mentorship extends Content{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int pk_cod_mentorship;
    @NotNull
    public String name;
    @NotNull
    public String description;
    @NotNull
    public String mentorship_date;

    @Override
    protected double calculateXP() {
        return STANDARD_XP + 20;
    }

    public Mentorship(){

    }

    /**
     * Construtor para criar um novo construtor na DB
     * @param name
     * @param description
     */

    public Mentorship(String name, String description) {
        this.name = name;
        this.description = description;
        //Pensando que o administrador cria a mentoria 20 dias antes de sua exibição
        LocalDate data = LocalDate.now().plusDays(20);

        this.mentorship_date = data.format(this.FORMAT);
    }
}
