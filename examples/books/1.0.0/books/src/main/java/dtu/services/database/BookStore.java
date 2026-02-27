package dtu.services.database;

import java.util.List;
import dtu.services.api.model.Bog;
import dtu.services.internal.model.Book;
import dtu.services.library.config.Databases;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import dtu.services.transformations.BookTransformer;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookStore
{
    @Autowired
    private Databases databases;

    @Autowired
    private BookTransformer transformer;


    public void insert(Bog bog)
    {
        Book book = transformer.getBook(bog);
        JdbcTemplate db = databases.getJdbcTemplate("test");
        String sql = "insert into books (id, title, author) values (?, ?, ?)";
        db.update(sql, book.getId(), book.getTitle(), book.getAuthor());
    }


    public Bog getById(Long id)
    {
        String sql = "select * from books where id = ?";
        JdbcTemplate db = databases.getJdbcTemplate("test");
        List<Book> books = db.query(sql, new DataClassRowMapper<>(Book.class),id);

        if (books.isEmpty()) return(null);
        return(transformer.getBog(books).get(0));
    }


    public List<Bog> getAll()
    {
        String sql = "select * from books";
        JdbcTemplate db = databases.getJdbcTemplate("test");
        List<Book> books = db.query(sql, new DataClassRowMapper<>(Book.class));
        return(transformer.getBog(books));
    }
}
