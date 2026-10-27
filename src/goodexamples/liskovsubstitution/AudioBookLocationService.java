package goodexamples.liskovsubstitution;

import dtos.BookMetadata;

public class AudioBookLocationService implements LibraryItemService {

    // ✅ An audiobook is found online. It keeps the same promise in its own way,
    // so it can be substituted anywhere a LibraryItemService is expected.
    @Override
    public String getLocation(BookMetadata metadata) {
        return "Online at https://library.com/stream/" + metadata.getIsbn();
    }

}
