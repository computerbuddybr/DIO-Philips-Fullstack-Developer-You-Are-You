package info.adrianacerdeira.desafio_poo;

import java.time.format.DateTimeFormatter;

public abstract class Content {
    protected static final double STANDARD_XP = 10d;

    protected String name;
    protected String description;

    protected final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Content(){

    }
    public Content(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract double calculateXp();

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
}
