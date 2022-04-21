package info.adrianacerdeira.desafio_poo;

public class Course extends Content {
    private int hours;

    public Course() {

    }

    public Course(String name, String description, int hours) {
        super(name, description);
        this.hours = hours;
    }

    @Override
    public double calculateXp() {
        return STANDARD_XP * hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "\nCurso: " + getName() +
                "\nCarga horária: " + getHours() +
                "\nDescrição" + getDescription() + "\n";
    }
}
