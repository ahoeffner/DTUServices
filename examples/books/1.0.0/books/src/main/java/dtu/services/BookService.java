package dtu.services;

import java.util.List;
import dtu.services.api.BooksApi;          // The generated interface
import dtu.services.api.model.Bog;         // The generated resource model
import dtu.services.database.BookStore;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import dtu.services.library.config.events.DTUEvents;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class BookService implements BooksApi
{
    @Autowired
    private DTUEvents events;

    @Autowired
    private BookStore bookstore;


    @Override
    public ResponseEntity<Bog> getById(@NotNull Long id)
    {
        Bog bog = bookstore.getById(id);

        if (bog == null)
            return(ResponseEntity.notFound().build());

        return(ResponseEntity.ok(bog));
    }


    @Override
    public ResponseEntity<List<Bog>> getAll()
    {
        List<Bog> books = bookstore.getAll();
        return(ResponseEntity.ok(books));
    }


    @Override
    public ResponseEntity<Bog> add(Bog bog)
    {
        bookstore.insert(bog);
        events.publish("new-book",bog);

        return(ResponseEntity.ok(bog));
    }
}