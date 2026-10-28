package dtos;

import java.time.LocalDate;
import java.util.Objects;

public class LoanDTO {

    private String isbn;
    private String title;
    private String memberId;
    private LocalDate dueDate;

    public LoanDTO() {
        super();
    }

    public LoanDTO(String isbn, String title, String memberId, LocalDate dueDate) {
        this.isbn = isbn;
        this.title = title;
        this.memberId = memberId;
        this.dueDate = dueDate;
    }

    // equals and hashCode methods for comparing LoanDTO objects based on isbn, title, memberId, and dueDate

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanDTO loanDTO = (LoanDTO) o;
        return Objects.equals(isbn, loanDTO.isbn) && Objects.equals(title, loanDTO.title) && Objects.equals(memberId, loanDTO.memberId) && Objects.equals(dueDate, loanDTO.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, memberId, dueDate);
    }

    @Override
    public String toString() {
        return "LoanDTO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", memberId='" + memberId + '\'' +
                ", dueDate=" + dueDate +
                '}';
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
