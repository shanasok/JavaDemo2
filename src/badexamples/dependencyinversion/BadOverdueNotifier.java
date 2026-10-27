package badexamples.dependencyinversion;

import dtos.BookDTO;

/*
* Example of a class that violates the Dependency Inversion Principle (DIP).
* High-level modules should not depend on low-level modules. Both should depend on abstractions.
*/
public class BadOverdueNotifier {

    // ❌ VIOLATION: The high-level business rule (tell members about overdue books) is
    // hard-wired to one concrete, low-level class. Switching to SMS, or using a fake
    // sender in a unit test, means modifying this class.
    private final EmailSender emailSender = new EmailSender();

    public void notifyOverdue(String memberId, BookDTO book, int daysLate) {
        String message = "\"" + book.getMetadata().getTitle() + "\" is " + daysLate + " days overdue.";
        emailSender.sendEmail(memberId, message);
    }

}
