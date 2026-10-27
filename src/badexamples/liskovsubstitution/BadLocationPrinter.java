package badexamples.liskovsubstitution;

import dtos.BookMetadata;

// Client code written against the parent class.
public class BadLocationPrinter {

    // ❌ Works for a BadBookService, but throws if given a BadAudioBookService,
    // even though the compiler says a BadAudioBookService *is a* BadBookService.
    public void printLocation(BadBookService service, BookMetadata metadata) {
        System.out.println(metadata.getTitle() + " -> " + service.getShelfLocation(metadata));
    }

}
