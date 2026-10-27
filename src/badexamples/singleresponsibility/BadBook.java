package badexamples.singleresponsibility;

/*
* Example of a class that violates the Single Responsibility Principle (SRP).
*/
public class BadBook {

    // Responsibility 1: Being a DTO (Data Transfer Object) for Book
    private String isbn;
    private String title;
    private String author;

    // Responsibility 2: Managing Book State/Data
    public String getBookSummary() {
        return title + " by " + author;
    }

    // ❌ Responsibility 3: Database Persistence Logic
    public void saveToDatabase() {
        // Direct database connection or execution logic
        String sql = "INSERT INTO books (isbn, title, author) VALUES (?, ?, ?)";
        System.out.println("Executing SQL query to save to database: " + sql);
    }

}
