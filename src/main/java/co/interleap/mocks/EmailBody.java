package co.interleap.mocks;

import java.util.Objects;

public class EmailBody {
    public final String subject;
    public final String body;
    public final String receiver;

    public EmailBody(String subject, String body, String receiver) {
        this.subject = subject;
        this.body = body;
        this.receiver = receiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailBody emailBody = (EmailBody) o;
        return Objects.equals(subject, emailBody.subject) && Objects.equals(body, emailBody.body) && Objects.equals(receiver, emailBody.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, body, receiver);
    }
}
