package booklookup.backend.Dtos;

import java.sql.Date;

public class BookDto {
    private long ISBN;

    private String thumbnailUrl;

    private String author;

    private String title;

    private Date published_date;

    private String shortDescription;

    public BookDto() {
    }

    public BookDto(long ISBN, String thumbnailUrl, String author, String title, Date published_date, String shortDescription) {
        this.ISBN = ISBN;
        this.thumbnailUrl = thumbnailUrl;
        this.author = author;
        this.title = title;
        this.published_date = published_date;
        this.shortDescription = shortDescription;
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

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
