package dtos;

import enums.AudienceAgeEnum;

import java.util.Objects;

public class BookMetadata {

    private String isbn;
    private String title;
    private String author;
    private AudienceAgeEnum audienceAge;

    public BookMetadata() {
        super();
    }

    public BookMetadata(String isbn, String title, String author, AudienceAgeEnum audienceAge) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.audienceAge = audienceAge;
    }

    // equals and hashCode methods for comparing BookMetadata objects based on ISBN
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookMetadata that = (BookMetadata) o;
        return Objects.equals(isbn, that.isbn) && Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(audienceAge, that.audienceAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, audienceAge);
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public AudienceAgeEnum getAudienceAge() {
        return audienceAge;
    }

    public void setAudienceAge(AudienceAgeEnum audienceAge) {
        this.audienceAge = audienceAge;
    }
}
