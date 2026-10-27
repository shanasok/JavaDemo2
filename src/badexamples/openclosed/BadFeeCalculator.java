package badexamples.openclosed;

import dtos.AudioBookDTO;
import dtos.BookDTO;

/*
* Example of a class that violates the Open/Closed Principle (OCP).
* Classes should be open for extension but closed for modification.
*/
public class BadFeeCalculator {

    // ❌ VIOLATION: The calculator has to know about every item type the library lends.
    // Adding a new type (e.g. an EBookDTO or DvdDTO) means reopening and editing this
    // already-tested method, instead of extending the system with new code.
    public double calculateLateFee(Object item, int daysLate) {
        if (item instanceof BookDTO) {
            return daysLate * 0.20; // 20p per day
        } else if (item instanceof AudioBookDTO) {
            return daysLate * 0.10; // 10p per day
        }

        throw new IllegalArgumentException("Unknown item type: " + item);
    }

}
