package pl.sda.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.sda.model.Book;
import pl.sda.repository.BookRepository;
import pl.sda.service.BookService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Primary
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        Book book = getById(id);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

}
