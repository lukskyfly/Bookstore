package pl.sda.service;

import pl.sda.model.Book;

import java.util.List;

public interface BookService {

    void save(Book book);

    Book getById(Integer id);

    List<Book> getAll();

    void update(Book book);

    void delete(Integer id);
}
