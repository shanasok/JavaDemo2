package goodexamples.liskovsubstitution;

import dtos.BookMetadata;

public class BookLocationService implements LibraryItemService {

    // ✅ A physical book is found on a shelf.
    @Override
    public String getLocation(BookMetadata metadata) {
        // For simplicity, let's say the shelf location is determined by the first letter of the title
        char firstLetter = Character.toUpperCase(metadata.getTitle().charAt(0));
        return "Shelf " + firstLetter;
    }

}
