package goodexamples.dependencyinversion;

public class SmsNotificationSender implements NotificationSender {

    @Override
    public void send(String memberId, String message) {
        System.out.println("Sending SMS to member " + memberId + ": " + message);
    }

}
