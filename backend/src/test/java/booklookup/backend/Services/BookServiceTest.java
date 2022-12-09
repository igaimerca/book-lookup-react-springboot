package booklookup.backend.Services;

import booklookup.backend.Models.Book;
import booklookup.backend.Repos.BookRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookRepo bookRepoMock;

    @InjectMocks
    private BookService bookService;

    List<Book> bookList = Arrays.asList(new Book(1L,33334,"https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg", "Aime Ig.","Learning SpringBoot.", LocalDate.parse("2004-04-05"),"Learning Springboot"));

    @Test
    public void getAll() {
        when(bookRepoMock.findAll()).thenReturn(bookList);
        assertEquals("33334", bookService.listOfBooks().get(0).getISBN());
        assertEquals(2, bookService.listOfBooks().size());
    }

    @Test
    public void create_success() {
        when(bookRepoMock.save(any(Book.class))).thenReturn(bookList.get(1));

        assertEquals("Aime Ig.", bookService.createBook(bookList.get(0)).getAuthor());
    }
}

