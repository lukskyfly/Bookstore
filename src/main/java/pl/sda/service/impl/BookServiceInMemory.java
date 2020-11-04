package pl.sda.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.model.Book;
import pl.sda.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceInMemory implements BookService {

    private int counter = 4;

    private List<Book> books;

    {
        books = new ArrayList<>();
        books.add(new Book(1,
                "Python dla każdego. Podstawy programowania",
                "Dawson Michael",
                "45234523",
                "Chcesz się nauczyć programować? Świetna decyzja! Wybierz język obiektowy, łatwy w użyciu, " +
                        "z przejrzystą składnią. Python będzie wprost doskonały! Rozwijany od ponad 20 lat, " +
                        "jest dojrzałym językiem, pozwalającym tworzyć zaawansowane aplikacje dla różnych systemów " +
                        "operacyjnych. Ponadto posiada system automatycznego zarządzania pamięcią, który zdejmuje " +
                        "z programisty obowiązek panowania nad tym skomplikowanym obszarem.",
                2014));
        books.add(new Book(2,
                "Czysty kod. Podręcznik dobrego programisty",
                "Robert C. Martin",
                "54325342",
                "Poznaj najlepsze metody tworzenia doskonałego kodu",
                2014));
        books.add(new Book(3,
                "Programista samouk. Profesjonalny przewodnik do samodzielnej nauki kodowania",
                "Althoff Cory",
                "634565",
                "Nie wystarczy znajomość jednego języka programowania, aby zostać programistą. " +
                        "W rzeczywistości trzeba opanować dość szeroki zakres pojęć i paradygmatów, a także zrozumieć " +
                        "zagadnienia związane z algorytmami. Trzeba być na bieżąco z nowymi technologiami i narzędziami. " +
                        "Należy również poznać i zacząć stosować dobre praktyki programistyczne i przyswoić sobie zasady " +
                        "pracy w zespole. Przede wszystkim jednak priorytetem jest sama praktyka, ponieważ wielu programistów " +
                        "wciąż ma problem z pisaniem poprawnego kodu.",
                2017));
    }

    @Override
    public void save(Book book) {
        book.setId(counter++);
        books.add(book);

    }

    @Override
    public Book getById(Integer id) {
        return books.stream()
                .filter(books -> books.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void update(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(book.getId())) {
                books.get(i).setTitle(book.getTitle());
                books.get(i).setAuthor(book.getAuthor());
                books.get(i).setIsbn(book.getIsbn());
                books.get(i).setDescription(book.getDescription());
                books.get(i).setYear(book.getYear());
                break;
            }

        }

    }

    @Override
    public void delete(Integer id) {
        Book book = getById(id);
        books.remove(book);
    }
}
