package dtu.services.transformations;

import dtu.services.api.model.Bog;
import dtu.services.internal.model.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T11:25:28+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.1 (Oracle Corporation)"
)
@Component
class BookTransformer$Bog2BookImpl implements BookTransformer.Bog2Book {

    @Override
    public Book toBook(Bog book) {
        if ( book == null ) {
            return null;
        }

        Book book1 = new Book();

        book1.setTitle( book.getTitel() );
        book1.setAuthor( book.getForfatter() );
        book1.setId( book.getId() );

        return book1;
    }

    @Override
    public List<Book> toBook(List<Bog> books) {
        if ( books == null ) {
            return null;
        }

        List<Book> list = new ArrayList<Book>( books.size() );
        for ( Bog bog : books ) {
            list.add( toBook( bog ) );
        }

        return list;
    }
}
