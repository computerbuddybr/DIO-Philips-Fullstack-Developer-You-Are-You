package info.adriana.eCommerceJavaAPI.entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BooksRepository extends CrudRepository<Books, Integer> {
    //public Iterable<Books> findAllByAuthor_code(int author_code);

    public Iterable<Books> findAllByPriceBetween(double lower, double highest);
    public Iterable<Books> findAllByAuthor(int author);

//    @Query(value = "select b.id, b.author, b.description, b.title, b.price, a.name  from books b inner join authors a on a.id=b.author")
//    public Optional<Books> findAllByAuthor();

    //    @Query(value = "select b.id, b.author, b.description, b.title, b.price, a.name  from books b inner join authors a on a.id=b.author where b.id=:id;")
//    public Optional<Books>  findBookAndAuthor();



}
