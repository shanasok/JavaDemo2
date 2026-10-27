package goodexamples.dependencyinversion;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void send(String memberId, String message) {
        System.out.println("Sending email to member " + memberId + ": " + message);
    }

}
