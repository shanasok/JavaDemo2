package services;

import dtos.BookDTO;

public class BookService {

    String getShelfLocation(BookDTO book) {
        // For simplicity, let's say the shelf location is determined by the first letter of the title
        char firstLetter = Character.toUpperCase(book.getMetadata().getTitle().charAt(0));
        return "Shelf " + firstLetter;
    }

}
