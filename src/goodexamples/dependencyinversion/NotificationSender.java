package goodexamples.dependencyinversion;

/*
* Abstraction that lets OverdueNotifier follow the Dependency Inversion Principle (DIP).
* Both the high-level notifier and the low-level senders depend on this interface.
*/
public interface NotificationSender {

    void send(String memberId, String message);

}
