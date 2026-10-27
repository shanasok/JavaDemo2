package badexamples.liskovsubstitution;

import dtos.BookMetadata;

public class BadAudioBookService extends BadBookService {

    // ❌ VIOLATION: The subclass breaks the promise its parent made. Code that works with
    // a BadBookService crashes when it is handed a BadAudioBookService instead.
    @Override
    public String getShelfLocation(BookMetadata metadata) {
        throw new UnsupportedOperationException("Audiobooks are digital and have no shelf.");
    }

}
