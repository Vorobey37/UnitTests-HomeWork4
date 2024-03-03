package task2Test;

import org.example.task2.Book;
import org.example.task2.BookRepository;
import static org.mockito.Mockito.*;

import org.example.task2.BookService;
import org.example.task2.InMemoryBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.*;

public class BookServiceTest {

    private Book mokBook1;
    private Book mokBook2;
    private BookRepository books;
    private BookService bookService;

    @BeforeEach
    void setUp(){

        mokBook1 = mock(Book.class);
        when(mokBook1.getAuthor()).thenReturn("Author1");
        when(mokBook1.getId()).thenReturn("1");
        when(mokBook1.getTitle()).thenReturn("Book1");

        mokBook2 = mock(Book.class);
        when(mokBook2.getAuthor()).thenReturn("Author2");
        when(mokBook2.getId()).thenReturn("2");
        when(mokBook2.getTitle()).thenReturn("Book2");

        books = mock(InMemoryBookRepository.class);

        bookService = new BookService(books);

    }

    @Test
    public void findBookByIdWithMok(){

        when(books.findById("1")).thenReturn(mokBook1);
        when(books.findById("2")).thenReturn(mokBook2);

        assertThat(bookService.findBookById("1").getId()).isEqualTo("1");
        assertThat(bookService.findBookById("1").getAuthor()).isEqualTo("Author1");
        assertThat(bookService.findBookById("1").getTitle()).isEqualTo("Book1");
        assertThat(bookService.findBookById("2").getId()).isEqualTo("2");
        assertThat(bookService.findBookById("2").getAuthor()).isEqualTo("Author2");
        assertThat(bookService.findBookById("2").getTitle()).isEqualTo("Book2");

    }

    @Test
    public void findAllBooks(){

        List<Book> bookList = new ArrayList<>();
        bookList.add(mokBook1);
        bookList.add(mokBook2);
        when(books.findAll()).thenReturn(bookList);

        assertThat(bookService.findAllBooks().get(0).getId()).isEqualTo("1");
        assertThat(bookService.findAllBooks().get(0).getAuthor()).isEqualTo("Author1");
        assertThat(bookService.findAllBooks().get(0).getTitle()).isEqualTo("Book1");
        assertThat(bookService.findAllBooks().get(1).getId()).isEqualTo("2");
        assertThat(bookService.findAllBooks().get(1).getAuthor()).isEqualTo("Author2");
        assertThat(bookService.findAllBooks().get(1).getTitle()).isEqualTo("Book2");

    }
}
