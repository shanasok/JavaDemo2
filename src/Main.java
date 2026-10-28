import badexamples.dependencyinversion.BadOverdueNotifier;
import badexamples.interfacesegregation.BadAudioBook;
import badexamples.liskovsubstitution.BadAudioBookService;
import badexamples.liskovsubstitution.BadBookService;
import badexamples.liskovsubstitution.BadLocationPrinter;
import badexamples.openclosed.BadFeeCalculator;
import badexamples.singleresponsibility.BadBook;
import dtos.AudioBookDTO;
import dtos.BookDTO;
import dtos.BookMetadata;
import enums.AudienceAgeEnum;
import goodexamples.dependencyinversion.OverdueNotifier;
import goodexamples.dependencyinversion.SmsNotificationSender;
import goodexamples.interfacesegregation.LibraryAudioBook;
import goodexamples.interfacesegregation.LibraryBook;
import goodexamples.liskovsubstitution.AudioBookLocationService;
import goodexamples.liskovsubstitution.BookLocationService;
import goodexamples.liskovsubstitution.LocationPrinter;
import goodexamples.openclosed.AudioBookLateFeePolicy;
import goodexamples.openclosed.BookLateFeePolicy;
import goodexamples.openclosed.FeeCalculator;
import goodexamples.singleresponsibility.BookDAO;
import mappers.BookMapper;

/*
* Runs each bad example next to its good example, one SOLID principle at a time.
*/
public class Main {

    public static void main(String[] args) {
        BookMetadata metadata = new BookMetadata("978-0441013593", "Dune", "Frank Herbert", AudienceAgeEnum.ADULT);
        BookDTO book = new BookDTO(metadata, 1.2);
        AudioBookDTO audioBook = new AudioBookDTO(metadata, "Scott Brick", 1260, "MP3");

        demoSingleResponsibility(book);
        demoOpenClosed(book, audioBook);
        demoLiskovSubstitution(metadata);
        demoInterfaceSegregation(book, audioBook);
        demoDependencyInversion(book);
    }

    private static void demoSingleResponsibility(BookDTO book) {
        printHeading("Single Responsibility");
        // BadBook mixes book data with saving to the database; BookDAO only handles saving.
        System.out.print("Bad:  ");
        new BadBook().saveToDatabase();
        System.out.print("Good: ");
        new BookDAO().save(new BookMapper().toModel(book));
    }

    private static void demoOpenClosed(BookDTO book, AudioBookDTO audioBook) {
        printHeading("Open/Closed");
        System.out.println("Bad:  book fee = " + new BadFeeCalculator().calculateLateFee(book, 5));
        System.out.println("Bad:  audiobook fee = " + new BadFeeCalculator().calculateLateFee(audioBook, 5));

        FeeCalculator calculator = new FeeCalculator();
        System.out.println("Good: book fee = " + calculator.calculateLateFee(new BookLateFeePolicy(), 5));
        System.out.println("Good: audiobook fee = " + calculator.calculateLateFee(new AudioBookLateFeePolicy(), 5));
    }

    private static void demoLiskovSubstitution(BookMetadata metadata) {
        printHeading("Liskov Substitution");
        BadLocationPrinter badPrinter = new BadLocationPrinter();
        badPrinter.printLocation(new BadBookService(), metadata);
        try {
            badPrinter.printLocation(new BadAudioBookService(), metadata);
        } catch (UnsupportedOperationException e) {
            System.out.println("Bad:  substituting BadAudioBookService crashed: " + e.getMessage());
        }

        LocationPrinter goodPrinter = new LocationPrinter();
        goodPrinter.printLocation(new BookLocationService(), metadata);
        goodPrinter.printLocation(new AudioBookLocationService(), metadata);
    }

    private static void demoInterfaceSegregation(BookDTO book, AudioBookDTO audioBook) {
        printHeading("Interface Segregation");
        try {
            new BadAudioBook(audioBook).getShippingWeightPounds();
        } catch (UnsupportedOperationException e) {
            System.out.println("Bad:  BadAudioBook was forced to implement shipping: " + e.getMessage());
        }

        LibraryBook libraryBook = new LibraryBook(book);
        System.out.println("Good: book is on " + libraryBook.getShelfLocation()
                + " and weighs " + libraryBook.getShippingWeightPounds() + " lb");
        System.out.println("Good: audiobook streams from " + new LibraryAudioBook(audioBook).generateStreamingUrl("member-42"));
    }

    private static void demoDependencyInversion(BookDTO book) {
        printHeading("Dependency Inversion");
        // The bad notifier can only ever email; the good one sends whatever it is given.
        new BadOverdueNotifier().notifyOverdue("member-42", book, 3);
        new OverdueNotifier(new SmsNotificationSender()).notifyOverdue("member-42", book, 3);
    }

    private static void printHeading(String principle) {
        System.out.println();
        System.out.println("=== " + principle + " ===");
    }

}
