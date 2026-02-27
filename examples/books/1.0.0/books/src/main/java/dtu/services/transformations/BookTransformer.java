package dtu.services.transformations;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import dtu.services.api.model.Bog;
import dtu.services.internal.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookTransformer
{
    @Autowired
    private Bog2Book bogmap;

    @Autowired
    private Book2Bog bookmap;


    public Book getBook(Bog bog)
    {
        return(this.bogmap.toBook(bog));
    }

    public List<Book> getBook(List<Bog> bog)
    {
        return(this.bogmap.toBook(bog));
    }

    public Bog getBog(Book book)
    {
        return(this.bookmap.toBook(book));
    }

    public List<Bog> getBog(List<Book> book)
    {
        return(this.bookmap.toBook(book));
    }


    @Mapper(componentModel = "spring")
    interface Bog2Book
    {
        // No need for mapping id,
        // since name and types are the same
        // @Mapping(source = "id", target = "id")

        @Mapping(source = "titel", target = "title")
        @Mapping(source = "forfatter", target = "author")

        Book toBook(Bog book);
        List<Book> toBook(List<Bog> books);
    }


    @Mapper(componentModel = "spring")
    interface Book2Bog
    {
        @Mapping(source = "title", target = "titel")
        @Mapping(source = "author", target = "forfatter")

        Bog toBook(Book book);
        List<Bog> toBook(List<Book> books);
    }
}
