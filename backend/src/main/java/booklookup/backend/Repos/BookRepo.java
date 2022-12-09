package booklookup.backend.Repos;

import booklookup.backend.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long> {
    public Optional<Book> findByISBN(Long ISBN);

    public List<Book> findByShortDescriptionContainingIgnoreCase(String key);
}
