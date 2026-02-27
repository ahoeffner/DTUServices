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
class BookTransformer$Book2BogImpl implements BookTransformer.Book2Bog {

    @Override
    public Bog toBook(Book book) {
        if ( book == null ) {
            return null;
        }

        Bog bog = new Bog();

        bog.setTitel( book.getTitle() );
        bog.setForfatter( book.getAuthor() );
        bog.setId( book.getId() );

        return bog;
    }

    @Override
    public List<Bog> toBook(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<Bog> list = new ArrayList<Bog>( books.size() );
        for ( Book book : books ) {
            list.add( toBook( book ) );
        }

        return list;
    }
}
