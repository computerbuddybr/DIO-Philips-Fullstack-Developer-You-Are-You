package info.adriana.eCommerceJavaAPI.controller;

import info.adriana.eCommerceJavaAPI.entities.Authors;
import info.adriana.eCommerceJavaAPI.entities.AuthorsRepository;
import info.adriana.eCommerceJavaAPI.entities.Books;
import info.adriana.eCommerceJavaAPI.entities.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private AuthorsRepository authorsRepository;

    /**
     * Will return all books available
     *
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public @ResponseBody Iterable<Books> showBooks() {
        return booksRepository.findAll();
    }

    /**
     * Will return one book by id
     *
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("books/{id}")
    public @ResponseBody Optional<Books> showBook(@PathVariable int id) {
        return booksRepository.findById(id);
    }

    /**
     * Will return all authors available
     *
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/authors")
    public @ResponseBody Iterable<Authors> showAuthors() {
        return authorsRepository.findAll();
    }

    /**
     * Will return all books from a certain author using their id from the Authors Table
     *
     * @param author_code
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/authors/{author_code}")
    public @ResponseBody Iterable<Books> showBooksFrom(@PathVariable int author_code) {
        Iterable<Books> info = booksRepository.findAllByAuthor(author_code);
        return info;

    }

    /**
     * Will return all books between a threshold of prices
     *
     * @param lowest
     * @param highest
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/books/{lowest}/{highest}")
    public @ResponseBody Iterable<Books> showForPriceBetween(@PathVariable double lowest, @PathVariable double highest) {
        Iterable<Books> info = booksRepository.findAllByPriceBetween(lowest, highest);
        return info;
    }

}
