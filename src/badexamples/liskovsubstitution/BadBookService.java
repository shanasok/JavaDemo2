package badexamples.liskovsubstitution;

import dtos.BookMetadata;

/*
* Base class for an example that violates the Liskov Substitution Principle (LSP).
* Subclasses should be usable anywhere their parent class is expected.
*/
public class BadBookService {

    // Promise to every caller: "give me an item and I'll tell you which shelf it's on."
    public String getShelfLocation(BookMetadata metadata) {
        // For simplicity, let's say the shelf location is determined by the first letter of the title
        char firstLetter = Character.toUpperCase(metadata.getTitle().charAt(0));
        return "Shelf " + firstLetter;
    }

}
