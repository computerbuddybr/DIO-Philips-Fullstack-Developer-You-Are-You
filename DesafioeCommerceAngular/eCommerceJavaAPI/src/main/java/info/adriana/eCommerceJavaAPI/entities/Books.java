package info.adriana.eCommerceJavaAPI.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @NotNull
    public int author;

    @NotNull
    public String title;

    @NotNull
    @Column(length = 2000)
    public String description;

    @NotNull
    public Double price;

    public Books() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
