package info.adriana.eCommerceJavaAPI.entities;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer> {
    //public Iterable<Books> findAllByAuthor_code(int author_code);

    public Iterable<Books> findAllByPriceBetween(double lower, double highest);
    public Iterable<Books> findAllByAuthor(int author);


}
