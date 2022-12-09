package booklookup.backend.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private long ISBN;

    private String thumbnailUrl;

    private String author;

    private String title;

    private LocalDate published_date;

    private String shortDescription;

    public Book() {
    }

    public Book(long id, long ISBN, String thumbnailUrl, String author, String title, LocalDate published_date, String shortDescription) {
        this.id = id;
        this.ISBN = ISBN;
        this.thumbnailUrl = thumbnailUrl;
        this.author = author;
        this.title = title;
        this.published_date = published_date;
        this.shortDescription = shortDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublished_date() {
        return published_date;
    }

    public void setPublished_date(LocalDate published_date) {
        this.published_date = published_date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN=" + ISBN +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", published_date=" + published_date +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }

}
