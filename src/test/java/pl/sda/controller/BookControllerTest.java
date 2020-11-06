package pl.sda.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.sda.model.Book;
import pl.sda.service.BookService;

import java.util.Arrays;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;
    private Book bookTest = new Book(1, "Pan Tadeusz", "Adam Mickiewicz", "12345", "opis", 1834);

    @Test
    public void bookListTest() throws Exception {
        //given
        Mockito.when(bookService.getAll()).thenReturn(Arrays.asList(bookTest));

        //when//then
        mockMvc.perform(MockMvcRequestBuilders.get("/book-list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("book-list"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"))
                .andExpect(MockMvcResultMatchers.model().attribute("books", Matchers.notNullValue()));
        Mockito.verify(bookService, Mockito.times(1)).getAll();

    }
    @Test
    public void saveBookTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/save-book")
                .param("id", Integer.toString(bookTest.getId()))
                .param("title",bookTest.getTitle())
                .param("author",bookTest.getAuthor())
                .param("isbn",bookTest.getIsbn())
                .param("description",bookTest.getDescription())
                .param("year",Integer.toString(bookTest.getYear())))
        //zakonczenie wywołanie metody perform
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/book-list"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/book-list"));
        //when//then
        Mockito.verify(bookService, Mockito.times(1)).save(bookTest);
    }
}
