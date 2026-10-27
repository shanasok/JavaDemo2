package goodexamples.singleresponsibility;

import dtos.BookDTO;

/*
* Example of a class that follows the Single Responsibility Principle (SRP).
* Compare with badexamples/singleresponsibility/BadBook.java.
*/
public class BookDAO {

    // ✅ ONE responsibility: database persistence for books.
    // The book data itself lives in dtos/BookDTO, so changing how books are stored
    // only means changing this class.
    public void save(BookDTO book) {
        if (book == null || book.getMetadata() == null) {
            throw new IllegalArgumentException("Book and its metadata are required.");
        }

        // Direct database connection or execution logic
        String sql = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";
        System.out.println("Executing SQL query to save to database: " + sql
                + " with isbn=" + book.getMetadata().getIsbn());
    }

}
