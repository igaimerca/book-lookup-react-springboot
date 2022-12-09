package booklookup.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import booklookup.backend.Dtos.BookDto;
import booklookup.backend.Models.Book;
import booklookup.backend.Services.BookService;

import java.util.*;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getBooks() {
        List<Book> books = bookService.listOfBooks();
        return books;
    }

    @GetMapping("/{book_id}")
    public Optional<Book> getBook(@PathVariable("book_id") Long bookId) {
        Optional<Book> book = bookService.getBook(bookId);
        return book;
    }

    @PutMapping("/edit/{book_id}")
    public ResponseEntity<Map> updateBook(@PathVariable("book_id") Long bookId, @RequestBody Book body) {
        Map<String, Object> response = new HashMap<>();
        Optional<Book> optionalBook = bookService.getBook(bookId);

        if (optionalBook.isEmpty()) {
            response.put("error", "No book with " + bookId + " id was found");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Book book = bookService.createBook(body);

        response.put("message", "Book updated successfully");
        response.put("book", book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{book_id}")
    public ResponseEntity<String> deleteBook(@PathVariable("book_id") Long bookId) {
        bookService.deleteBook(bookId);

        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/ISBN/{book_ISBN}")
    public Book getBookByISBN(@PathVariable("book_ISBN") Long ISBN) {
        return bookService.getByISBN(ISBN);
    }

    @GetMapping("/search/{key}")
    public List<Book> searchStudents(@PathVariable("key") String key) {
        return bookService.search(key);
    }
}
