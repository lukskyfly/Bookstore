package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Book;
import pl.sda.service.BookService;

@Slf4j
@Controller
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("book-list")
    public ModelAndView bookList() {
        ModelAndView  modelAndView = new ModelAndView("book-list");
        modelAndView.addObject("books", bookService.getAll());
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("currentUser", username);
        return modelAndView;
    }

    @GetMapping("book-detail/{bookId}")
    public ModelAndView bookDetail(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("book-detail");
        modelAndView.addObject("book", bookService.getById(bookId));
        return modelAndView;
    }

    @GetMapping("delete-book/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) {
        bookService.delete(bookId);
        log.info("Left " + bookService.getAll().size() + " books.");
        return "redirect:/book-list";
    }

    @GetMapping("edit-book/{bookId}")
    public ModelAndView editBook(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("edit-book");
        modelAndView.addObject("book", bookService.getById(bookId));
        return modelAndView;
    }

    @PostMapping("update-book")
    public String updateBook(@ModelAttribute Book book) {
        bookService.update(book);
        log.info("Updated book: " + book);
        return "redirect:/book-list";
    }

    @GetMapping("admin/add-book")
    public ModelAndView addBook() {
        ModelAndView modelAndView = new ModelAndView("add-book");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("save-book")
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        log.info("Added book: " + book);
        return "redirect:/book-list";
    }
}
