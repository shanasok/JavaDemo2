package goodexamples.dependencyinversion;

import dtos.BookDTO;

/*
* Example of a class that follows the Dependency Inversion Principle (DIP).
* Compare with badexamples/dependencyinversion/BadOverdueNotifier.java.
*/
public class OverdueNotifier {

    // ✅ Depends on the NotificationSender abstraction, not a concrete class.
    private final NotificationSender sender;

    // ✅ The concrete sender is passed in (dependency injection), so callers choose
    // email, SMS, or a fake for tests without this class changing.
    public OverdueNotifier(NotificationSender sender) {
        this.sender = sender;
    }

    public void notifyOverdue(String memberId, BookDTO book, int daysLate) {
        String message = "\"" + book.getMetadata().getTitle() + "\" is " + daysLate + " days overdue.";
        sender.send(memberId, message);
    }

}
