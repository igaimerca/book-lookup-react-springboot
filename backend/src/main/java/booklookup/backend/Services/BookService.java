package booklookup.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import booklookup.backend.Models.Book;
import booklookup.backend.Repos.BookRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public BookService() {
    }

    public List<Book> listOfBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBook(Long id) {
        return bookRepo.findById(id);
    }

    public Book createBook(Book Book) {
        return bookRepo.save(Book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public Book getByISBN(Long ISBN) {
        return bookRepo.findByISBN(ISBN).get();
    }

    public List<Book> search(String key){
        return bookRepo.findByShortDescriptionContainingIgnoreCase(key);
    }
}
