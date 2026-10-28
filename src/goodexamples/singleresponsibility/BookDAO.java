package goodexamples.singleresponsibility;

import models.Book;

/*
* Example of a class that follows the Single Responsibility Principle (SRP).
* Compare with badexamples/singleresponsibility/BadBook.java.
*/
public class BookDAO {

    // ✅ ONE responsibility: database persistence for books.
    // The book data itself lives in models/Book, so changing how books are stored
    // only means changing this class.
    public void save(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book is required.");
        }

        // Direct database connection or execution logic
        String sql = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";
        System.out.println("Executing SQL query to save to database: " + sql
                + " with isbn=" + book.getIsbn());
    }

}
