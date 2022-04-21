package info.adrianacerdeira.desafio_poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String name;
    private String description;
    //Passei a inicialização das datas para o contrutor pensando em um CRUD futuro onde também teria a opção de obter as datas da DB
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Set<Dev> subscribedDevs = new HashSet<>();
    private Set<Content> contents = new LinkedHashSet<>();

    protected final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Bootcamp() {
    }

    public Bootcamp(String name, String description) {
        this.name = name;
        this.description = description;
        //Pensando que o Bootcamp começaria 20 dias depois de um admin criá-lo
        this.initialDate = LocalDate.now().plusDays(20);
        this.finalDate = this.initialDate.plusDays(45);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Decidi retornar as datas já formatadas por questão de visualização
    public String getInitialDate() {
        return initialDate.format(this.FORMAT);
    }

    public String getFinalDate() {
        return finalDate.format(this.FORMAT);
    }

    public Set<Dev> getSubscribedDevs() {
        return subscribedDevs;
    }

    public void setSubscribedDevs(Set<Dev> subscribedDevs) {
        this.subscribedDevs = subscribedDevs;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(name, bootcamp.name) && Objects.equals(description, bootcamp.description) && Objects.equals(initialDate, bootcamp.initialDate) && Objects.equals(finalDate, bootcamp.finalDate) && Objects.equals(subscribedDevs, bootcamp.subscribedDevs) && Objects.equals(contents, bootcamp.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, initialDate, finalDate, subscribedDevs, contents);
    }

    @Override
    //Para poder mostrar os Bootcamps inscritos
    public String toString() {
        return "\nBootcamp: " + getName() +
                "\nDescrição: " + getDescription() + '\'' +
                "\nData Inicial: " + getInitialDate() +
                "\nData Final: " + getFinalDate();
    }
}
