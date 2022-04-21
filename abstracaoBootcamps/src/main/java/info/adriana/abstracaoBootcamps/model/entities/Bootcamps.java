package info.adriana.abstracaoBootcamps.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Bootcamp extends Content{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int pk_cod_bootcamp;

    @NotNull
    public String name;
    @NotNull
    public String description;
    @NotNull
    public String start_date;
    @NotNull
    public String final_date;

    public Bootcamp(){

    }

    public Bootcamp(String name, String description) {
        this.name = name;
        this.description = description;

        //pensando que o administrador cria um bootcamp 20 dias antes de seu início
        LocalDate dataInicio = LocalDate.now().plusDays(20);
        LocalDate dataFinal = dataInicio.plusDays(45);
        this.start_date = dataInicio.format(this.FORMAT);
        this.final_date = dataFinal.format(this.FORMAT);
    }

    @Override
    protected double calculateXP() {
        return STANDARD_XP + 50;
    }


}
