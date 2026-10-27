package goodexamples.interfacesegregation;

import dtos.BookDTO;

/*
* Example of classes that follow the Interface Segregation Principle (ISP).
* Compare with badexamples/interfacesegregation/BadLibraryItem.java and badexamples/interfacesegregation/BadAudioBook.java.
*/
public class LibraryBook implements Shelvable, Shippable {

    private final BookDTO book;

    public LibraryBook(BookDTO book) {
        this.book = book;
    }

    // ✅ A physical book only implements the interfaces it can actually fulfil.
    @Override
    public String getShelfLocation() {
        // For simplicity, let's say the shelf location is determined by the first letter of the title
        char firstLetter = Character.toUpperCase(book.getMetadata().getTitle().charAt(0));
        return "Shelf " + firstLetter;
    }

    @Override
    public double getShippingWeightPounds() {
        return book.getShippingWeightPounds();
    }

}
