package badexamples.interfacesegregation;

import dtos.AudioBookDTO;

public class BadAudioBook implements BadLibraryItem {

    private final AudioBookDTO audioBook;

    public BadAudioBook(AudioBookDTO audioBook) {
        this.audioBook = audioBook;
    }

    // ❌ Forced to implement: an audiobook is digital, so it has no shelf.
    @Override
    public String getShelfLocation() {
        throw new UnsupportedOperationException("Audiobooks are not stored on a shelf.");
    }

    // ❌ Forced to implement: an audiobook is never shipped.
    @Override
    public double getShippingWeightPounds() {
        throw new UnsupportedOperationException("Audiobooks cannot be shipped.");
    }

    // The only method that actually makes sense for an audiobook.
    @Override
    public String generateStreamingUrl(String memberId) {
        return "https://library.com/stream/" + audioBook.getBookMetadata().getIsbn() + "?member=" + memberId;
    }

}
