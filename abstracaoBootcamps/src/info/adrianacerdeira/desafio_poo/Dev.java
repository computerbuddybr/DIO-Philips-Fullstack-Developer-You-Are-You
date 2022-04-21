package info.adrianacerdeira.desafio_poo;

import java.util.*;

public class Dev {

    private String name;
    private Set<Content> subscribedContent = new LinkedHashSet<>();
    private Set<Content> finishedContent = new LinkedHashSet<>();

    public Dev() {

    }

    public Dev(String name) {
        this.name = name;

    }

    public void subscribeBootcamp(Bootcamp bootcamp) {
        this.subscribedContent.addAll(bootcamp.getContents());
        bootcamp.getSubscribedDevs().add(this);

    }

    public void progress() {
        Optional<Content> content = this.subscribedContent.stream().findFirst();
        if (content.isPresent()) {
            this.finishedContent.add(content.get());
            this.subscribedContent.remove(content.get());
        } else {
            System.err.println(("Você não está matriculado em nenhum conteúdo. Corra já e matricule-se!"));
        }
    }

    public double calculateTotalXp() {
        Iterator<Content> iterator = this.finishedContent.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            double next = iterator.next().calculateXp();
            sum += next;
        }
        return sum;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getSubscribedContent() {
        return subscribedContent;
    }

    public void setSubscribedContent(Set<Content> subscribedContent) {
        this.subscribedContent = subscribedContent;
    }

    public Set<Content> getFinishedContent() {
        return finishedContent;
    }

    public void setFinishedContent(Set<Content> finishedContent) {
        this.finishedContent = finishedContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(subscribedContent, dev.subscribedContent) && Objects.equals(finishedContent, dev.finishedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedContent, finishedContent);
    }
}
