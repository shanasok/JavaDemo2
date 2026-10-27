package badexamples.dependencyinversion;

// Low-level detail: knows how to send an email.
public class EmailSender {

    public void sendEmail(String memberId, String message) {
        System.out.println("Sending email to member " + memberId + ": " + message);
    }

}
