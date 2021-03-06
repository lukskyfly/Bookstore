package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sda.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByIsbn(String isbn);

    Book findByTitle(@Param("title") String title);
}
