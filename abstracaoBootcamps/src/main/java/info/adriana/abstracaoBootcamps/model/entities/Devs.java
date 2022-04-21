package info.adriana.abstracaoBootcamps.model.entities;

import com.sun.istack.NotNull;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Dev {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column("pk_cod_dev")
    private int pk_cod_dev;


    @NotNull
    public String name;






    public Dev(){

    }


    public Dev(String name){
        this.name = name;
    }


    public int getPk_cod_dev() {
        return pk_cod_dev;
    }

    public void setPk_cod_dev(int pk_cod_dev) {
        this.pk_cod_dev = pk_cod_dev;
    }
}
