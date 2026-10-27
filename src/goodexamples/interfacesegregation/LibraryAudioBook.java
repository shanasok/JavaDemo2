package goodexamples.interfacesegregation;

import dtos.AudioBookDTO;

public class LibraryAudioBook implements Streamable {

    private final AudioBookDTO audioBook;

    public LibraryAudioBook(AudioBookDTO audioBook) {
        this.audioBook = audioBook;
    }

    // ✅ An audiobook only implements Streamable, so there are no shelf or shipping stubs.
    @Override
    public String generateStreamingUrl(String memberId) {
        return "https://library.com/stream/" + audioBook.getBookMetadata().getIsbn() + "?member=" + memberId;
    }

}
