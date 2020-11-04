package pl.sda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.service.BookService;
@Slf4j
@Controller
public class BookController {
    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("book-list")
    public ModelAndView bookList(){
        ModelAndView modelAndView = new ModelAndView("book-list");
        modelAndView.addObject("books",bookService.getAll());
        return modelAndView;
    }
    @GetMapping("book-detail/{bookId}")
    public ModelAndView bookDetail(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("book-detail");
        modelAndView.addObject("book",bookService.getById(bookId));
        return modelAndView;
    }
    @GetMapping("delete-book/{bookId}")
    public String deleteBook(@PathVariable Integer bookId){
        bookService.delete(bookId);
        log.info("Pozostało: " + bookService.getAll().size() + " ksiazek");
        return "redirect:/book-list";

    }
}

