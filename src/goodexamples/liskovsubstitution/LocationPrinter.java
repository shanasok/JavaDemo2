package goodexamples.liskovsubstitution;

import dtos.BookMetadata;

/*
* Example of client code that benefits from the Liskov Substitution Principle (LSP).
* Compare with badexamples/liskovsubstitution/BadLocationPrinter.java.
*/
public class LocationPrinter {

    // ✅ Works with any LibraryItemService, so a new item type never makes it crash.
    public void printLocation(LibraryItemService service, BookMetadata metadata) {
        System.out.println(metadata.getTitle() + " -> " + service.getLocation(metadata));
    }

}
