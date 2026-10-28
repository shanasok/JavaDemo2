package models;

import enums.AudienceAgeEnum;

import java.time.LocalDate;

/*
* Base class for anything the library lends out.
* Holds the shared fields and borrowing logic once; each subclass only says how long its loans last.
*/
public abstract class LibraryItem implements Borrowable {

    private final String isbn;
    private final String title;
    private final String author;
    private final AudienceAgeEnum audienceAge;

    private String borrowedBy;
    private LocalDate dueDate;

    protected LibraryItem(String isbn, String title, String author, AudienceAgeEnum audienceAge) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.audienceAge = audienceAge;
    }

    protected abstract int getLoanPeriodDays();

    @Override
    public boolean isAvailable() {
        return borrowedBy == null;
    }

    @Override
    public void borrow(String memberId, LocalDate borrowDate) {
        if (!isAvailable()) {
            throw new IllegalStateException("'" + title + "' is already borrowed.");
        }
        this.borrowedBy = memberId;
        this.dueDate = borrowDate.plusDays(getLoanPeriodDays());
    }

    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Getters

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public AudienceAgeEnum getAudienceAge() {
        return audienceAge;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

}
